package com.bobby.peng.learning.exams;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 *
 *
 * @author <a href="mailto:peng2035@163.com">彭天浩</a>
 * @version 1.0
 */
public class ClassBExtendA extends ClassA{

    public String bField;

    public static void main(String[] args) throws NoSuchMethodException {
        ClassBExtendA classBExtendA = new ClassBExtendA();

        Method method = ClassA.test(classBExtendA);
        if(method == null)
            System.out.println("null");

        System.out.println(111);
    }

    public String getbField() {
        return bField;
    }

    public void setbField(String bField) {
        this.bField = bField;
    }
}
