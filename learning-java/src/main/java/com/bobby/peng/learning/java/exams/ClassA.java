package com.bobby.peng.learning.java.exams;

import java.lang.reflect.Method;

/**
 *
 *
 * @author <a href="mailto:peng2035@163.com">彭天浩</a>
 * @version 1.0
 */
public class ClassA {

    private String field1 = "HELLO";

    public ClassA() {

    }

    public static Method test(ClassA classA) throws NoSuchMethodException {
        return classA.getClass().getMethod("getbField");
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }
}
