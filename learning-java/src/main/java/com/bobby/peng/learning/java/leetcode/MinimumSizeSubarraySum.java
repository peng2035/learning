package com.bobby.peng.learning.java.leetcode;

/**
 * Created by bobby.peng on 2017/1/12.
 */
public class MinimumSizeSubarraySum {

    public int minSubArrayLen(int s, int[] nums) {
        int temp = 0;
        int delIndex = -1;
        int minLength = 0;
        for(int i=0;i<nums.length;i++) {
            temp += nums[i];

            if(delIndex != -1) {
                temp -= nums[delIndex];
                delIndex++;
            } else {
                if(temp >= s) {
                    delIndex = 0;
                    minLength = i+1;
                }
            }
            while(delIndex > -1 && temp - nums[delIndex] >= s) {
                temp -= nums[delIndex];
                delIndex++;
                minLength--;
            }
            if(minLength == 1) return 1;
        }
        return minLength;
    }

    public static void main(String[] args) {
        MinimumSizeSubarraySum minimumSizeSubarraySum = new MinimumSizeSubarraySum();
        int[] nums = {1,2,3,4,5};
        System.out.println(minimumSizeSubarraySum.minSubArrayLen(11,nums));
    }
}
