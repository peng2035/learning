package com.bobby.peng.learning.java.leetcode;

/**
 * Created by bobby.peng on 2017/10/18.
 */

public class RangeAddition2 {

    public int maxCount(int m, int n, int[][] ops) {
        if(ops.length==0) return m*n;
        int minM = ops[0][0];
        int minN = ops[0][1];
        for(int i=1;i<ops.length;i++) {
            if(ops[i][0] < minM) {
                minM = ops[i][0];
            }
            if(ops[i][1] < minN) {
                minN = ops[i][1];
            }
        }
        return minM * minN;
    }

}
