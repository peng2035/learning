package com.bobby.peng.learning.java.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bobby.peng on 2017/10/23.
 */
public class NumberOfDigitOne {

    public int countDigitOne(int n) {
        if (n <= 0)
            return 0;
        if (n < 10)
            return 1;
        Map<Integer, Integer> map = new HashMap<>();

        Map<Integer, Integer> max = new HashMap<>();
        max.put(0,1);

        String input = String.valueOf(n);
        int length = input.length();
        int current = input.charAt(length - 1) - 48;
        int ten = 1;
        map.put(0, current == 0 ? 0 : 1);

        for (int i = 1; i < length; i++) {
            ten *= 10;
            max.put(i, 10 * max.get(i - 1) + ten);

            int temp = input.charAt(length - 1 - i) - 48;

            if (temp == 0) {
                map.put(i, map.get(i - 1));
            }

            if (temp == 1) {
                map.put(i, max.get(i - 1) + current + 1 + map.get(i - 1));
            }

            if (temp > 1) {
                map.put(i, temp * max.get(i - 1) + map.get(i - 1) + ten);
            }
            current += temp * ten;
        }

        return map.get(length - 1);
    }

    public static void main(String[] args) {
        NumberOfDigitOne numberOfDigitOne = new NumberOfDigitOne();
        System.out.println(numberOfDigitOne.countDigitOne(100));
    }

}
