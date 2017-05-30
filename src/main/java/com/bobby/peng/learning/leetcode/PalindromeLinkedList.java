package com.bobby.peng.learning.leetcode;

import com.bobby.peng.learning.basic.data.structure.ListNode;
import com.bobby.peng.learning.basic.utils.ListNodeUtils;

/**
 * Created by peng2035 on 2017/4/12.
 */
public class PalindromeLinkedList {

    public ListNode currentNode;
    public boolean flag = false;
    public boolean isPalindrome(ListNode head) {
        currentNode = head;
        if(head == null) return true;
        return check(head);
    }

    public boolean check(ListNode head) {
        if(head == null) return true;
        if(!check(head.next)) {
            return false;
        }
        if(flag) return true;
        if(currentNode == head) {
            flag = true;
            return true;
        }
        if(currentNode.val != head.val) {
            return false;
        } else {
            currentNode = currentNode.next;
            if(currentNode == head) {
                flag = true;
            }
            return true;
        }

    }

    public static void main(String[] args) {
        ListNode listNode = ListNodeUtils.buildListNode(new int[]{1,2,3,4,4,3,2,1});

        PalindromeLinkedList p = new PalindromeLinkedList();
        System.out.println(p.isPalindrome(listNode));
    }
}
