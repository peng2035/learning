package com.bobby.peng.learning.basic.test;

import com.bobby.peng.learning.exams.ClassA;
import com.bobby.peng.learning.exams.ClassB;

/**
 *
 *
 * @author <a href="mailto:peng2035@163.com">彭天浩</a>
 * @version 1.0
 */
public class ConstantPool {

    class Class1 {
        String value;

        public Class1(String value) {
            this.value = value;
        }
    }

    class Class2 {
        String value;

        public Class2(String value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        ConstantPool constantPool = new ConstantPool();
        Class1 class1 = constantPool.new Class1("12345");
        Class2 class2 = constantPool.new Class2("12345");

        if(class1.value == class2.value) System.out.println("is true");

        ClassA classA = new ClassA();
        ClassB classB = new ClassB();

        if(classA.getField1() == classB.getField1()) System.out.printf("is true");
    }

}
