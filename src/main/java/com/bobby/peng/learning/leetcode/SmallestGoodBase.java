package com.bobby.peng.learning.leetcode;

import java.io.File;
import java.io.IOException;

/**
 * Created by bobby.peng on 2017/1/23.
 */
public class SmallestGoodBase {

    public String smallestGoodBase(String n) {
        long input = Long.parseLong(n);

        for(long q=2;q<input;q++) {
            System.out.println(q);
        }

        return "";
    }


    public static void main(String[] args) {
        File file = new File("D:\\123.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(111);
    }
}
