package com.bobby.peng.learning.java.learning.basic.utils;

import com.bobby.peng.learning.java.basic.utils.StringUtils;
import org.junit.Test;

/**
 * Created by peng2035 on 2017/5/30.
 */
public class StringUtilsTest{

    static class A {
        int value;

        public A(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return StringUtils.fieldToString(this);
        }
    }

    static class B extends A {
        int bValue;

        public B(int value,int bValue) {
            super(value);
            this.bValue = bValue;
        }

        @Override
        public String toString() {
            return StringUtils.fieldToString(this);
        }
    }

    @Test
    public void test_field_to_string() {
        B b = new B(1,2);
        System.out.println(b.toString());
    }
}
