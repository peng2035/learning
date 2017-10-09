package com.bobby.peng.learning.java.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by peng2035 on 2017/4/3.
 */
public class KDiffPairsInAnArray {
    Map<Integer, Integer[]> map = new HashMap<>();

    int result = 0;

    public int findPairs(int[] nums, int k) {
        if (k < 0) return 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) != null) continue;

            int left = nums[i] - k;
            int right = nums[i] + k;
            if (map.containsKey(left)) {
                put(left, nums[i]);
            }
            if (map.containsKey(right)) {
                put(right, nums[i]);
            }

            if (map.get(nums[i]) == null) {
                map.put(nums[i], null);
            }

        }

        return result;
    }

    public void put(int key, int num) {
        if (!map.containsKey(key)) {
            return;
        }

        Integer[] value = map.get(key);

        if (value == null) {
            value = new Integer[2];
            value[0] = num;
            result++;
            map.put(key, value);
        } else {
            if (value[0].equals(num)) {
                return;
            }
            if (value[1] == null) {
                value[1] = num;
                result++;
                return;
            }
            return;
        }
    }

    public static void main(String[] args) {
        KDiffPairsInAnArray kDiffPairsInAnArray = new KDiffPairsInAnArray();

        kDiffPairsInAnArray.findPairs(new int[]{1, 3, 1, 3, 5}, 2);
    }
}
