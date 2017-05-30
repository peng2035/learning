package com.bobby.peng.learning.leetcode;

import com.bobby.peng.learning.basic.data.structure.LinkedNode;
import com.bobby.peng.learning.basic.utils.LinkedNodeUtils;

/**
 * Created by bobby.peng on 2016/11/17.
 */
public class LinkedListCycle {

    public boolean hasCycle(LinkedNode head) {
        if (head == null || head.next == null) {
            return false;
        } else {
            while (head.next != null) {
                if(head == head.next) {
                    return true;
                }
                head.next = head.next.next;
                head = head.next;
                if (head == null) {
                    return false;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        LinkedListCycle linkedListCycle = new LinkedListCycle();

        for(int i=5;i<100;i++) {
            int[] values = new int[i+1];
            for(int j=0;j<i;j++) {
                values[j] = j+1;
            }
            values[i] = 5;
            LinkedNode head = LinkedNodeUtils.buildLinkedNodeList(values);

            System.out.println(linkedListCycle.hasCycle(head));

        }



//        for(int i=0;i<100;i++) {
//            System.out.println(head.next + "->");
//            head = head.next;
//        }
    }
}
