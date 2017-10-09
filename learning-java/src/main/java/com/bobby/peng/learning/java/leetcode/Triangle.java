package com.bobby.peng.learning.java.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bobby.peng on 2017/1/13.
 */
public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size() == 1) {
            return triangle.get(0).get(0);
        }

        List<List<Integer>> preResult = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        List<Integer> first = new ArrayList<>();
        first.add(triangle.get(0).get(0));
        preResult.add(first);
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> list = new ArrayList<>();
            List<Integer> preList = preResult.get(i - 1);
            int length = triangle.get(i).size();
            for (int j = 0; j < length; j++) {
                int current = triangle.get(i).get(j);
                int pre1;
                int pre2;
                int temp;
                if(j==0) {
                    pre1 = preList.get(j);
                    temp = pre1 + current;
                } else if(j==length-1) {
                    pre2 = preList.get(j-1);
                    temp = pre2 + current;
                } else {
                    pre1 = preList.get(j);
                    pre2 = preList.get(j-1);
                    temp = (pre1 < pre2 ? pre1 : pre2) + current;
                }
                if(i==triangle.size() - 1) {
                    min = min < temp ? min : temp;
                }
                list.add(temp);
            }
            preResult.add(list);
        }
        return min;
    }
}
