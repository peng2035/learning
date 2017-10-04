package com.bobby.peng.learning.basic.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by peng2035 on 2017/7/25.
 */
public class Test {
    class TestString {
        public String value;

        public TestString(String value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Test test = new Test();

        TestString testString = test.new TestString("123");

        String temp = testString.value;
        testString.value = "35";

        System.out.println(temp);
        System.out.println(testString.value);


    }
}
