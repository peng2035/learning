package com.bobby.peng.learning.exams;

/**
 *
 *
 * @author <a href="mailto:peng2035@163.com">彭天浩</a>
 * @version 1.0
 */
public class OuterClass {

    private String hello = "hello";

    private class InnerClass {

        public InnerClass() {
            System.out.println(OuterClass.this.hello);
            OuterClass outerClass = new OuterClass();
            outerClass.setHello("hello1");
            System.out.println(outerClass.getHello());
            System.out.println(OuterClass.this.getHello());
        }

    }

    private static class InnerStaticClass {
        
    }

    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }

    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();

        OuterClass.InnerClass innerClass = outerClass.new InnerClass();

    }
}
