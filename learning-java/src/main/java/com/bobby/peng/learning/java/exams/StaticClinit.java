package com.bobby.peng.learning.java.exams;

/**
 *
 *
 * @author <a href="mailto:peng2035@163.com">彭天浩</a>
 * @version 1.0
 */
public class StaticClinit {

    static {
        a=2;
    }

    private static int a = 1;

    public static void main(String[] args) {
        System.out.println(StaticClinit.a);
    }
}
