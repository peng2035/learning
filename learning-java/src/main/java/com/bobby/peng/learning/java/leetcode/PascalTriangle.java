package com.bobby.peng.learning.java.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bobby.peng on 2017/1/9.
 */
public class PascalTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) {
            return result;
        }
        if (numRows > 0) {
            List<Integer> list = new ArrayList<>(1);
            list.add(1);
            result.add(list);
        }
        if (numRows > 1) {
            List<Integer> list = new ArrayList<>(2);
            list.add(1);
            list.add(1);
            result.add(list);
        }
        if (numRows > 2) {
            for (int i = 2; i < numRows; i++) {
                List<Integer> list = new ArrayList<>(i + 1);
                int middle = 0;
                int flag = (i + 1) % 2;
                if (flag == 0) {
                    middle = (i + 1) / 2 - 1;
                } else {
                    middle = (i + 1) / 2;
                }
                List<Integer> lastList = result.get(i - 1);
                list.add(1);
                for (int m = 1; m < i; m++) {
                    if (m <= middle) {
                        list.add(lastList.get(m - 1) + lastList.get(m));
                    } else {
                        if (flag == 0) {
                            list.add(list.get(2 * middle - m + 1));
                        } else {
                            list.add(list.get(2 * middle - m));
                        }
                    }
                }
                list.add(1);
                result.add(list);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        PascalTriangle pascalTriangle = new PascalTriangle();
        pascalTriangle.generate(4);
    }
}
