package com.bobby.peng.learning.java.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bobby.peng on 2017/1/8.
 */
public class CombinationSum3 {

    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> result = new ArrayList<>();
        result = buildResult(n,k,0,1,0);
        return result;
    }

    public int checkMinAndMax(int length, int startNum, int diff) {
        if (9 - startNum < length - 1) {
            return 0;
        }
        int min = 0;
        int max = 0;
        for (int i = 0; i < length; i++) {
            min += startNum + i;
            if (min > diff) return 0;
            max += 9 - i;
        }

        if (max < diff) return 2;

        return 1;
    }

    public List<List<Integer>> buildResult(int n, int k, int index, int startNum, int sum) {
        List<List<Integer>> re = new ArrayList<>();
        int diff = n - sum;
        if (index == k - 1) {
            if (diff >= startNum && diff < 10) {
                List<Integer> value = new ArrayList<>();
                for(int i=0;i<k;i++) {
                    if(i!=index) {
                        value.add(0);
                    } else {
                        value.add(diff);
                    }
                }
                re.add(value);
            }
            return re;
        }
        for (int i = startNum; i < 10; i++) {
            int code = checkMinAndMax(k - index - 1, i + 1, diff - i);
            if (code == 0) {
                break;
            } else if(code == 2) {
                continue;
            }
            List<List<Integer>> value = buildResult(n, k, index + 1, i + 1, sum + i);

            for(List<Integer> temp : value) {
                temp.set(index,i);
            }
            re.addAll(value);
        }
        return re;
    }

    public static void main(String[] args) {
        CombinationSum3 combinationSum3 = new CombinationSum3();
        combinationSum3.combinationSum3(3,15);
    }
}
