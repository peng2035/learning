package com.bobby.peng.learning.java.leetcode;

/**
 * Created by bobby.peng on 2017/1/10.
 */
public class CircularArrayLoop {

    //todo
    public boolean circularArrayLoop(int[] nums) {
        int fastIndex = 0;
        int slowIndex = 0;

        while (++slowIndex < nums.length) {
            fastIndex += 2;
            fastIndex = fastIndex >= nums.length ? fastIndex - nums.length : fastIndex;

            if (slowIndex == fastIndex) {
                continue;
            }
            if (nums[slowIndex] == nums[fastIndex]) {
                return true;
            }
        }
        return false;
    }

}
