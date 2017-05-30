package com.bobby.peng.learning.leetcode;

/**
 * Created by bobby.peng on 2016/8/9.
 */
public class MergeKSortedLists {


    //https://leetcode.com/problems/merge-k-sorted-lists/
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        ListNode(int x, ListNode listNode) {
            this.val = x;
            this.next = listNode;
        }
    }

    public class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            boolean endFlag = false;
            ListNode head = null;
            ListNode currentNode = head;
            while (!endFlag) {
                ListNode temp = null;
                int arrayNum = -1;
                for (int i = 0; i < lists.length; i++) {

                    ListNode listNode = lists[i];
                    if (listNode == null) {
                        continue;
                    }

                    if (temp == null) {
                        arrayNum = i;
                        temp = listNode;
                    } else {
                        if (listNode.val < temp.val) {
                            arrayNum = i;
                            temp = listNode;
                        }
                    }
                }
                if(arrayNum == -1) {
                    break;
                } else {
                    lists[arrayNum] = lists[arrayNum].next;
                }

                if (currentNode == null) {
                    currentNode = temp;
                    head = currentNode;
                } else {
                    currentNode.next = temp;
                    currentNode = currentNode.next;
                }
            }

            return head;// TODO: 2016/8/9
        }
    }

    public ListNode[] buildLists(int[]... arrays) {
        ListNode currentListNode = null;
        ListNode preListNode = null;
        ListNode[] lists = new ListNode[arrays.length];
        for (int i = 0; i < arrays.length; i++) {
            for(int j = arrays[i].length -1; j>=0;j--) {
                if(preListNode == null) {
                    preListNode = new ListNode(arrays[i][j] ,null);
                } else {
                    currentListNode = new ListNode(arrays[i][j],preListNode);
                    preListNode = currentListNode;
                }
            }
            lists[i] = preListNode;
            preListNode = null;
        }
        return lists;
    }



    public static void main(String[] args) {
        int[] array1 = {1, 3, 4, 5, 7, 9, 20};
        int[] array2 = {2, 11, 21};
        int[] array3 = {8, 10, 12, 15, 19};

        MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();


        Solution solution = mergeKSortedLists.new Solution();



        ListNode listNode = solution.mergeKLists(mergeKSortedLists.buildLists(array1,array2,array3));
        int i = 0;
        while(listNode!=null) {
            System.out.print(listNode.val + "  ");
            listNode = listNode.next;
            i++;
        }
        System.out.println();
        System.out.println(i);
    }
}
