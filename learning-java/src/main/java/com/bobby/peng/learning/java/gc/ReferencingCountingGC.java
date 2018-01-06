package com.bobby.peng.learning.java.gc;

/**
 * Created by bobby.peng on 05/01/2018.
 */
public class ReferencingCountingGC {

    public static int _1M = 1024 * 1024;

    public Object instance = null;

    private byte[] value = new byte[2 * _1M];

    public static void main(String[] args) {
        ReferencingCountingGC r1 = new ReferencingCountingGC();
        ReferencingCountingGC r2 = new ReferencingCountingGC();

        r1.instance = r2;
        r2.instance = r1;

        r1 = null;
        r2 = null;

        System.gc();
    }
}
