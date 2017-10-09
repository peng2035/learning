package com.bobby.peng.learning.java.leetcode;

/**
 * Created by bobby.peng on 2017/1/12.
 */
public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        if(nums.length == 1) return 0;
        int left = 0;
        int right = nums.length - 1;
        int middle = (left + right) / 2;
        while (left <= right) {
            middle = (left + right) / 2;

            int value = nums[middle];
            if (middle == 0) {
                if (value > nums[1]) return middle;
                left = middle + 1;
                continue;
            } else if (middle == nums.length - 1) {
                if (value > nums[nums.length - 2]) return middle;
                right = middle -1;
                continue;
            } else {

                if (value > nums[middle - 1] && value > nums[middle + 1]) {
                    return middle;
                } else if (value < nums[middle - 1]) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            }
        }
        return middle;
    }

    public static void main(String[] args) {
        FindPeakElement findPeakElement = new FindPeakElement();
        int[] nums = {3,2,1};

        int result = findPeakElement.findPeakElement(nums);
        System.out.println(result);
    }
}
