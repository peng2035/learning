package com.bobby.peng.learning.leetcode;

/**
 *
 *
 * @author <a href="mailto:peng2035@163.com">彭天浩</a>
 * @version 1.0
 */
public class FactorialTrailingZeroes {

    public static int trailingZeros(int n) {
        int x = (int) (Math.log(n) / Math.log(5));

        int result = 0;
        for (int i = x; i > 0; i--) {
            result += n/((int)Math.pow(5,i));
        }

        return result;
    }

    public static void main(String[] args) {
        trailingZeros(0);
    }
}
