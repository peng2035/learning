package com.bobby.peng.learning.java.leetcode;

/**
 * Created by bobby.peng on 2017/1/22.
 */
public class PredictTheWinner {

    public static boolean PredictTheWinner(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        return PredictTheWinner(nums, start + 1, end, nums[start], false) || PredictTheWinner(nums, 0, end - 1, nums[end], false);
    }

    public static boolean PredictTheWinner(int[] nums, int start, int end, int value, boolean flag) {
        if (start == end) {
            if (flag) {
                return value + nums[start] >= 0 ? true : false;
            } else {
                return value - nums[start] >= 0 ? true : false;
            }
        } else if (start > end) {
            return value >= 0 ? true : false;
        }
        if (flag) {
            return (PredictTheWinner(nums, start + 1, end, value + nums[start], false)
                    || PredictTheWinner(nums, start, end - 1, value + nums[end], false));
        } else {
            return (PredictTheWinner(nums, start + 1, end, value - nums[start], true)
                    && PredictTheWinner(nums, start, end - 1, value - nums[end], true));
        }
    }

    public static void main(String[] args) {
        PredictTheWinner predictTheWinner = new PredictTheWinner();
        int[] nums = {2,4,55,6,8};
        predictTheWinner.PredictTheWinner(nums);
    }
}
