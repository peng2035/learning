package com.bobby.peng.learning.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bobby.peng on 2016/8/29.
 */
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> remainNums = new ArrayList<Integer>();
        for (int num : nums) {
            remainNums.add(num);
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        permute(result, nums, new ArrayList<Integer>(), remainNums);
        return result;
    }

    public void permute(List<List<Integer>> result, int[] nums, List<Integer> tempList, List<Integer> remainList) {

        if (tempList.size() == nums.length) {

            List<Integer> list = new ArrayList<Integer>();
            for (int j = 0; j < tempList.size(); j++) {
                list.add(tempList.get(j));
            }
//            tempList.add(remainList.get(0));
            result.add(list);
            return;
        }

        for (int i = 0; i < remainList.size(); i++) {
            int value = remainList.remove(i);
            tempList.add(value);
            permute(result, nums, tempList, remainList);
            remainList.add(i, value);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        Permutations p = new Permutations();
        int[] a = {1, 2, 3};
        List<List<Integer>> lists = p.permute(a);
        System.out.println(lists);
    }
}
