package com.bobby.peng.learning.leetcode;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by bobby.peng on 2017/1/3.
 */
public class ContainsDuplicate2 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            Integer value = map.get(nums[i]);
            if (value == null) {
                map.put(nums[i], i);
            } else {
                if (i - value <= k) return true;
                else map.put(nums[i], i);
            }
        }

        return false;
    }
}
