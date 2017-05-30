package com.bobby.peng.learning.exams;

/**
 * Created by bobby.peng on 2017/1/25.
 */
public class Intern {

    public static void main(String[] args) {
        String s0 = "aaaa";
        String s3 = new StringBuilder("aaaa").toString();
        s3.intern();
        String s4 = "aaaa";
        System.out.println(s3==s4);

        String s1 = new StringBuilder("aa").append("aa").toString();
        s1.intern();
        String s2 = "aaaa";
        System.out.println(s1==s2);
    }

}
