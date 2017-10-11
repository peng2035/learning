package com.bobby.peng.learning.java.knowledge;

import com.bobby.peng.learning.java.exams.ClassA;

/**
 * Created by peng2035 on 2017/5/30.
 */
public class FinalLearning {

    int value;

    final int finalValue;

    static FinalLearning finalLearning;

    public static final ClassA CLASS_A = new ClassA();

    public FinalLearning(int value, int finalValue) {
        this.value = value;
        this.finalValue = finalValue;
    }

    public static void write() {
        finalLearning = new FinalLearning(1,2);
    }

    public static void read() {
        FinalLearning finalLearning2 = finalLearning;
        int value = finalLearning.value;
        int finalValue = finalLearning.finalValue;
    }

    public static void main(String[] args) {
        FinalLearning finalLearning = new FinalLearning(1,2);
        System.out.println(finalLearning.finalValue);
        System.out.println(FinalLearning.CLASS_A.getField1());
        System.out.println(111);
    }
}
