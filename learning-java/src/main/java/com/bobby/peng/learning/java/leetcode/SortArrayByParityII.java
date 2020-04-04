package com.bobby.peng.learning.java.leetcode;

import com.alibaba.fastjson.JSON;

/**
 * Created by bobby.peng on 2018/10/31.
 */
public class SortArrayByParityII {
    public int[] sortArrayByParityII(int[] A) {
        Node lastEven = null;
        Node lastOdd = null;
        for (int i = 0; i < A.length; i++) {
            if ((A[i] & 1) == (i & 1)) continue;

            if ((i & 1) == 0) {
                if (lastOdd != null) {
                    exchange(A, lastOdd.index, i);
                    lastOdd = lastOdd.next;
                    continue;
                }
                Node temp = new Node(i);
                if (lastEven == null) {
                    lastEven = temp;
                } else {
                    temp.next = lastEven;
                    lastEven = temp;
                }
            } else {
                if (lastEven != null) {
                    exchange(A, lastEven.index, i);
                    lastEven = lastEven.next;
                    continue;
                }

                Node temp = new Node(i);
                if (lastOdd == null) {
                    lastOdd = temp;
                } else {
                    temp.next = lastOdd;
                    lastOdd = temp;
                }
            }


        }
        return A;
    }

    public static void exchange(int[] A, int index1, int index2) {
        int temp = A[index1];
        A[index1] = A[index2];
        A[index2] = temp;
    }

    public static class Node {
        Node next;
        int index;

        public Node(int index) {
            this.next = null;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        SortArrayByParityII sortArrayByParityII = new SortArrayByParityII();
        sortArrayByParityII.sortArrayByParityII(new int[]{2, 0, 1, 4, 0, 2, 4, 2, 3, 1, 1, 3, 0, 1, 1, 2, 2, 3, 3, 3});
    }

}
