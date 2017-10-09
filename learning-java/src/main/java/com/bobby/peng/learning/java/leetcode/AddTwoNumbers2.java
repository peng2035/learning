package com.bobby.peng.learning.java.leetcode;

import com.bobby.peng.learning.java.basic.data.structure.ListNode;
import com.bobby.peng.learning.java.basic.utils.ListNodeUtils;

/**
 *
 *
 * @author <a href="mailto:peng2035@163.com">彭天浩</a>
 * @version 1.0
 */
public class AddTwoNumbers2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int[] lengths = getLength(l1, l2);

        ListNode node = add(l1,l2,lengths[0]-lengths[1]);

        ListNode head = node;
        if(head.val > 9) {
            head = new ListNode(1);
            head.next = node;
            node.val -= 10;
        }

        return head;
    }

    public ListNode add(ListNode l1, ListNode l2, int diffIndex) {
        if (diffIndex == 0) {
            if (l1.next == null && l2.next == null) {
                return new ListNode(l1.val + l2.val);
            } else {
                ListNode last = add(l1.next, l2.next, 0);
                ListNode temp = new ListNode(l1.val + l2.val);
                temp.next = last;
                if (last.val > 9) {
                    last.val -= 10;
                    temp.val += 1;
                }
                return temp;
            }
        } else if (diffIndex > 0) {
            ListNode last = add(l1.next, l2, --diffIndex);
            ListNode temp = new ListNode(l1.val);
            temp.next = last;
            if (last.val > 9) {
                last.val -= 10;
                temp.val += 1;
            }
            return temp;
        } else {
            ListNode last = add(l1, l2.next, ++diffIndex);
            ListNode temp = new ListNode(l2.val);
            temp.next = last;
            if (last.val > 9) {
                last.val -= 10;
                temp.val += 1;
            }
            return temp;
        }
    }

    public int[] getLength(ListNode l1, ListNode l2) {
        int[] values = new int[2];

        while (l1 != null && l2 != null) {
            l1 = l1.next;
            l2 = l2.next;
            values[0]++;
            values[1]++;
        }

        while (l1 != null) {
            l1 = l1.next;
            values[0]++;
        }

        while (l2 != null) {
            l2 = l2.next;
            values[1]++;
        }

        return values;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNodeUtils.buildListNode(new int[] {7,2,4,3});
        ListNode l2 = ListNodeUtils.buildListNode(new int[] {5,6,4});

        AddTwoNumbers2 addTwoNumbers2 = new AddTwoNumbers2();
        ListNode result = addTwoNumbers2.addTwoNumbers(l1,l2);
        ListNodeUtils.print(result);
    }
}
