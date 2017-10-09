package com.bobby.peng.learning.java.disruptor.exam;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Created by bobby.peng on 2017/10/9.
 */
public class UnsafeExam {
    public volatile int         value = 0;
    private static final Unsafe unsafe;
    static {
        try {
            unsafe = getUnsafeInstance();
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    private static Unsafe getUnsafeInstance()
            throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field theUnsafeInstance = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafeInstance.setAccessible(true);
        return (Unsafe) theUnsafeInstance.get(Unsafe.class);
    }

    public static void main(String[] args) {
        int s = unsafe.arrayIndexScale(int[].class);
        System.out.println(s);
        int o = unsafe.arrayIndexScale(Object[].class);
        System.out.println(o);
    }
}
