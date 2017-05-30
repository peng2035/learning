package com.bobby.peng.learning.leetcode;

/**
 * Created by bobby.peng on 2016/12/1.
 */
public class Pattern132 {
    //https://leetcode.com/problems/132-pattern/
    public boolean find132pattern(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            while (i < nums.length - 2 && nums[i] > nums[i + 1]) {
                i++;
            }

            int middle = i + 1;
            while (middle < nums.length - 1 && nums[middle] < nums[middle + 1]) {
                middle++;
            }

            int nextI = middle + 1;
            for (int m = middle + 1; m < nums.length; m++) {
                if (nums[m] < nums[i] && nextI == middle + 1) {
                    nextI = m - 1;
                }
                if (nums[m] > nums[i] && nums[m] < nums[middle]) {
                    return true;
                }
            }
            i = nextI;
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {8,10,4,6,5};
        Pattern132 pattern132 = new Pattern132();
        System.out.println(pattern132.find132pattern(nums));
    }
}
