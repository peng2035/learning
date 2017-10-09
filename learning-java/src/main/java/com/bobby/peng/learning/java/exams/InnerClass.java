package com.bobby.peng.learning.java.exams;

/**
 *
 *
 * @author <a href="mailto:peng2035@163.com">彭天浩</a>
 * @version 1.0
 */
public class InnerClass {

    public class InnerClassA {
        public InnerClassA() {
            System.out.println("Class A start");
        }

        public void printMessage() {
            System.out.println("hello world!");
        }
    }

    private class InnerClassB {
        private InnerClassB() {
            System.out.println("Class B start");
        }
    }

    public static class StaticInnerClass {
        public void printMessage() {
            System.out.println("hello world");
        }
    }

    public void create() {
        System.out.println("in create method");
        InnerClassA innerClassA = new InnerClassA();
        InnerClassB innerClassB = new InnerClassB();
    }

    public static void main(String[] args) {
        InnerClass innerClass = new InnerClass();
        innerClass.create();
    }
}
