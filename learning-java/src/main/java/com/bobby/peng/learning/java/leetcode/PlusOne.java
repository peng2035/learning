package com.bobby.peng.learning.java.leetcode;

/**
 * Created by bobby.peng on 2017/1/11.
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        int[] result = new int[digits.length + 1];
        boolean flag = false;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
                flag = true;
            } else {
                digits[i]++;
                flag = false;
            }
            if (flag == false) {
                return digits;
            }
        }
        result[0] = 1;
        return result;
    }

    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
        int[] a = {8,9,9,9};
        int[] result = plusOne.plusOne(a);
        for(int i=0;i<result.length;i++) {
            System.out.print(result[i] + " ");
        }
    }

}
