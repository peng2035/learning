package com.bobby.peng.learning.java.basic.test;

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
