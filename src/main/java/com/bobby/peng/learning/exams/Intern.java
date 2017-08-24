package com.bobby.peng.learning.exams;

import java.util.LinkedHashMap;

/**
 * Created by bobby.peng on 2017/1/25.
 */
public class Intern {
    private int value = 1;

    private String s3 = "bobby";

    private void test() {
        String s2 = new StringBuilder("kp").append("l").toString();

        System.out.println(s2.intern() == s2);

        String s1 = new String("fed");
        while(true){}
//        System.out.println(s1.intern() == s1);
    }

    public static void main(String[] args) {
//        Intern intern = new Intern();
//
//        intern.test();

        System.out.println(1+1+'1'+1+1+1+1+"1");

        LinkedHashMap<String,String> map = new LinkedHashMap<>();

        map.remove("1");

    }

}
