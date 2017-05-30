package com.bobby.peng.learning.leetcode;

import java.util.*;

/**
 * Created by bobby.peng on 2016/12/6.
 */
public class TopKFrequentElements {

    public List<Integer> topKFrequent(int[] nums, int k) {
        if(nums==null || nums.length == 0) return null;
        int max = 0;
        int min = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer value = map.get(nums[i]);
            if (value == null) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], ++value);
            }
        }

        List<Integer>[] result = new List[nums.length];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            List<Integer> list = result[value];

            if (list == null) {
                list = new ArrayList<>();
                result[value] = list;
            }
            list.add(entry.getKey());

            if (value > max) max = value;
            if (value < min) min = value;

        }

        List<Integer> top = new ArrayList<>(k);
        int j = k;
        for (int i = max; i >= min; i--) {
            if(result[i]==null) continue;
            for (int m = 0; j > 0 && m < result[i].size(); m++) {
                if (result[i] != null) {
                    top.add(result[i].get(m));
                    j--;
                } else {
                    break;
                }
            }

        }

        return top;
    }

    public static void main(String[] args) {
        System.out.println(new Date(1481340280000l));
    }
}
