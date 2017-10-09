package com.bobby.peng.learning.java.leetcode;

import java.util.*;

/**
 * Created by bobby.peng on 2016/8/30.
 */
public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<Integer> remains = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            remains.add(nums[i]);
        }
        Arrays.sort(nums);

        List<Integer> temp = new ArrayList<Integer>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        Set<List<Integer>> set = new LinkedHashSet<List<Integer>>();
        fourSum(nums, target, temp, -1, set);

        for (List<Integer> list : set) {
            result.add(list);
        }

        return result;
    }

    public void fourSum(int[] nums, int target, List<Integer> temp, int lastTempIndex, Set<List<Integer>> set) {

        if (temp.size() == 4) {
            int sum = 0;
            //            System.out.println(temp);
            for (int i = 0; i < temp.size(); i++) {
                int current = temp.get(i);

                sum += current;
            }

            if (sum != target) return;
            List<Integer> list = new ArrayList<Integer>();

            for (int i : temp) {
                list.add(i);
            }

            set.add(list);
            return;
        }

        for (int j = lastTempIndex + 1; j <= nums.length + temp.size() - 4; j++) {
            temp.add(nums[j]);
            fourSum(nums, target, temp, j, set);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        FourSum fourSum = new FourSum();
        int[] nums = {-3, -2, -1, 0, 0, 1, 2, 3};
        System.out.println(fourSum.fourSum(nums, 0));
    }

}
