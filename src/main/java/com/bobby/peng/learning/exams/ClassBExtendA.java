package com.bobby.peng.learning.exams;

/**
 *
 *
 * @author <a href="mailto:peng2035@163.com">彭天浩</a>
 * @version 1.0
 */
public class ClassBExtendA extends ClassA{

    public static void main(String[] args) {
        ClassA classBExtendA = new ClassBExtendA();

        System.out.println(classBExtendA.getClass() == ClassA.class);
    }
}
