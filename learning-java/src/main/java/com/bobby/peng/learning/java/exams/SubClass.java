package com.bobby.peng.learning.java.exams;

/**
 * Created by bobby.peng on 02/01/2018.
 */
public class SubClass extends ParentClass {

    @Override
    public void doExtend1() {
        System.out.println("in subclass do extend1");
        startTransaction();
        super.doExtend1();
    }

    @Override
    public void doExtend2() {
        System.out.println("in subclass do extend2");
        startTransaction();
        super.doExtend2();
    }

    private void startTransaction() {
        System.out.println("sub class transaction start");
    }

    public static void main(String[] args) {
        SubClass subClass = new SubClass();

        subClass.doExtend1();
    }

}
