package com.bobby.peng.learning.java.leetcode;

/**
 * Created by bobby.peng on 2017/1/10.
 */
public class NumberComplement {

    public int findComplement(int num) {
        return ((Integer.highestOneBit(num) << 1) - 1) & ~num;
    }

    public static void main(String[] args) {
        NumberComplement numberComplement = new NumberComplement();
        System.out.println(numberComplement.findComplement(8));
    }
}
