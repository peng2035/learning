package com.bobby.peng.learning.basic.utils;

import com.bobby.peng.learning.basic.data.structure.ListNode;

/**
 * Created by bobby.peng on 2016/11/18.
 */
public class ListNodeUtils {

    public static ListNode buildListNode(int[] values) {
        ListNode nextNode = null;
        for(int i=values.length - 1; i>=0;i--) {
            ListNode listNode = new ListNode(values[i]);
            listNode.next = nextNode;
            nextNode = listNode;
            if(i==0) {
                return listNode;
            }
        }

        return null;
    }

    public static void print(ListNode head) {
        int i = 0;
        while(head != null) {
            System.out.print(head.val + " ");
            head = head.next;
            if(i++==1000) {
                throw new RuntimeException();
            }
        }
        System.out.println();
    }

}
