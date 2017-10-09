package com.bobby.peng.learning.java.leetcode;

/**
 * Created by bobby.peng on 2017/1/12.
 */
public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        Integer[][] result = new Integer[nums.length][2];
        int max = nums[0];
        if(nums[0] > 0) {
            result[0][0] = nums[0];
            result[0][1] = null;
        } else {
            result[0][0] = null;
            result[0][1] = nums[0];
        }
        for(int i=1;i<nums.length;i++) {
            if(nums[i] < 0) {
                if(result[i-1][1] == null) {
                    result[i][0] = null;
                } else {
                    result[i][0] = result[i-1][1] * nums[i];
                    max = max < result[i][0] ? result[i][0] : max;
                }
                if(result[i-1][0] == null || result[i-1][0] == 0) {
                    result[i][1] = nums[i];
                    max = max < result[i][1] ? result[i][1] : max;
                } else {
                    result[i][1] = nums[i] * result[i-1][0];
                }
            } else {
                if(result[i-1][0] == null || result[i-1][0] == 0) {
                    result[i][0] = nums[i];
                    max = max < result[i][0] ? result[i][0] : max;
                } else {
                    result[i][0] = result[i-1][0] * nums[i];
                    max = max < result[i][0] ? result[i][0] : max;
                }
                if(result[i-1][1] == null) {
                    result[i][1] = nums[i];
                } else {
                    result[i][1] = nums[i] * result[i-1][1];
                }
            }
        }
        return max;
    }

}
