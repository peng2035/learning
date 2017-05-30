package com.bobby.peng.learning.exams;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by bobby.peng on 2017/2/16.
 */
public class StackCombine {
    public static int largestPalindrome(int n) {
        int a = 1;
        while (n-- > 0) {
            a = a * 10;
        }
        int i = a - 1;
        long max = 0;
        while (i >= a / 10) {
            for (int j = i; j >= a / 10; j--) {
                long value = i * j;
                if (max > value) {
                    break;
                }
                System.out.println(value);
                if (judgePalindrome(value)) {
                    System.out.println("i ：" + i + "  j : " + j + "value : " + value + "  max : " + max);
                    max = value;
                }
            }
            i--;
        }
        System.out.println(max);
        long result = max % 1337;
        return Long.valueOf(result).intValue();
    }

    public static boolean judgePalindrome(long n) {
        char[] temp = String.valueOf(n).toCharArray();
        int length = temp.length;
        for (int i = 0; i < length / 2; i++) {
            if (temp[i] != temp[length - i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        StackCombine stackCombine = new StackCombine();
        stackCombine.largestPalindrome(5);
    }
}
