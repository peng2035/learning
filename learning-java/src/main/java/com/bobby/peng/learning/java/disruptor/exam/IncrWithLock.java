package com.bobby.peng.learning.java.disruptor.exam;

public class IncrWithLock {

    public static void main(String[] args) {
        int num = 500000000;
        int value = 0;
        long withoutLock = System.currentTimeMillis();
        for (int i = 0; i < num; i++) {
            value+=2;
        }
        System.out.println("without lock : " + (System.currentTimeMillis() - withoutLock));
        System.out.println("value : " + value);

        long withLock = System.currentTimeMillis();
        for (int i = 0; i < num; i++) {
            synchronized (IncrWithLock.class) {
                value++;
            }
        }
        System.out.println("with lock : " + (System.currentTimeMillis() - withLock));
        System.out.println(value);
    }
}
