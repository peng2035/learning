package com.bobby.peng.learning.java.leetcode;

/**
 * Created by bobby.peng on 2016/11/17.
 */
public class CountingBits {
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        result[0] = 0;
        if (num == 0) {
            return result;
        }
        result[1] = 1;
        if (num == 1) {
            return result;
        }
        result[2] = 1;
        if (num == 2) {
            return result;
        }

        int lastSectionValue = 2;
        int nextSectionValue = 4;
        for (int i = 3; i <= num; i++) {
            if (i < nextSectionValue) {
                result[i] = 1 + result[i - lastSectionValue];
            } else if (i == nextSectionValue) {
                result[i] = 1;
                lastSectionValue = i;
                nextSectionValue = 2 * i;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        CountingBits countingBits = new CountingBits();
        for (int i : countingBits.countBits(15)) {
            System.out.print(i + ",");
        }
    }
}
