package com.bobby.peng.learning.java.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bobby.peng on 2017/1/3.
 */
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            Integer startNum = null;
            while (i + 1 < nums.length && nums[i] == nums[i + 1] - 1) {
                if (startNum == null) {
                    startNum = nums[i];
                }
                i++;
            }
            if (i + 1 == nums.length) {
                if (startNum == null) {
                    result.add(String.valueOf(nums[i]));
                    break;
                } else {
                    result.add(String.valueOf(startNum) + "->" + String.valueOf(nums[i]));
                    break;
                }
            } else if (startNum != null) {
                result.add(String.valueOf(startNum) + "->" + String.valueOf(nums[i]));
            } else {
                result.add(String.valueOf(nums[i]));
            }
        }
        return result;
    }
}
