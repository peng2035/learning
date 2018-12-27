package com.bobby.peng.learning.java.algorithm;

/**
 * Created by bobby.peng on 2018/11/16.
 */
public class Diomand {

    public static void main(String[] args) {
        int col = 5, middle = col / 2;
        for (int i = 0; i < col; i++) {
            int blank = Math.abs(middle - i), length = 2 * middle + 1 - blank;
            for (int j = 0; j < length; j++) {
                while (j<blank) { System.out.print(" ");j++;}
                System.out.print("*");
            }

            System.out.println();
        }
    }
}
