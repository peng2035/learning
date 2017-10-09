package com.bobby.peng.learning.java.leetcode;

/**
 * Created by bobby.peng on 2017/1/12.
 */
public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1, middle = (left + right) / 2;

        if(nums[left] < nums[right]) return nums[left];
        while (right > left) {
            middle = (left + right) / 2;
            if (nums[left] > nums[middle]) {
                right = middle;
            } else {
                left = middle;
            }
            if(right - left == 1) {
                return nums[left] < nums[right] ? nums[left] : nums[right];
            }
        }

        return nums[middle];
    }

}
