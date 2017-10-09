package com.bobby.peng.learning.java.leetcode;

/**
 * Created by bobby.peng on 2017/1/11.
 */
public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] clone = nums1.clone();
        for(int i=0,index1=0,index2=0;i<m+n;i++) {
            if(index1 == m) {
                while(index2 < n) {
                    nums1[i++] = nums2[index2++];
                }
                return;
            } else if(index2 == n) {
                while (index1 < m) {
                    nums1[i++] = clone[index1++];
                }
                return;
            }

            int temp;
            if(clone[index1] <= nums2[index2]) {
                temp=clone[index1];
                index1++;
            } else {
                temp=nums2[index2];
                index2++;
            }
            nums1[i] = temp;
        }
    }

    public static void main(String[] args) {
        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        int[] nums1 = {1,2,3,4,5,6,7};
        int m = 5;
        int[] nums2 = {1,2,3,4,5,6,7};
        int n = 2;
        mergeSortedArray.merge(nums1,m,nums2,n);
        for(int i=0;i<nums1.length;i++) {
            System.out.print(nums1[i] + " ");
        }
    }
}
