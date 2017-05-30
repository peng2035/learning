package com.bobby.peng.learning.leetcode;

/**
 * Created by bobby.peng on 2016/9/30.
 */
public class RotateFunction {

    public int maxRotateFunction(int[] A) {
        int[] result = new int[A.length];

        if(A.length == 0) return 0;
        Integer max = null;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                int weight = (i + j) >= A.length ? (i + j - A.length) : (i + j);
                result[j] += weight * A[i];
                if (i == A.length - 1) {
                    if(max == null) {
                        max = result[j];
                    } else if(max < result[j]) {
                        max = result[j];
                    }
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] a = {4, 3, 2, 6};
        RotateFunction rotateFunction = new RotateFunction();
        rotateFunction.maxRotateFunction(a);
        System.out.printf("111");
    }

}
