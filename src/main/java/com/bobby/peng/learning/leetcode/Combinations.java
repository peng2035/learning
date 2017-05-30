package com.bobby.peng.learning.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * @author <a href="mailto:peng2035@163.com">彭天浩</a>
 * @version 1.0
 */
public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<Integer> remains = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            remains.add(i);
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        combine(result, n, k, new ArrayList<Integer>(), remains);

        return result;
    }

    public void combine(List<List<Integer>> result, int n, int k, List<Integer> temps, List<Integer> remains) {

        if (temps.size() == k) {
            List<Integer> list = new ArrayList<Integer>();

            for (int i = 0; i < temps.size(); i++) {
                list.add(temps.get(i));
            }
            result.add(list);

            return;
        }

        int startNum = 0;
        if (temps.size() > 0) {
            startNum = temps.get(temps.size() - 1) ;
        }
        for (int i = startNum; i < remains.size(); i++) {
            temps.add(i + 1);
            combine(result, n, k, temps, remains);
            temps.remove(temps.size() - 1);
        }
    }

    public static void main(String[] args) {
        Combinations combinations = new Combinations();
        System.out.println(combinations.combine(4, 2));
    }
}
