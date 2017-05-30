package com.bobby.peng.learning.leetcode;

/**
 * Created by bobby.peng on 2017/1/11.
 */
public class RotateArray {

    public void rotate(int[] nums, int k) {
        k = k % nums.length;

        reverse(nums,0,k-1);
        reverse(nums,k,nums.length - 1);
        reverse(nums,0,nums.length -1);
    }

    private void reverse(int[] nums, int startIndex, int endIndex) {
        while (startIndex < endIndex) {
            int temp = nums[startIndex];

            nums[startIndex] = nums[endIndex];
            nums[endIndex] = temp;
            endIndex--;
            startIndex--;
        }
    }

}
