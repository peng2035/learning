package com.bobby.peng.learning.java.disruptor.exam;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CASLock {

    public volatile int value = 0;
    private static final Unsafe unsafe;
    private static final long valueOffset;

    static {
        try {
            unsafe = getUnsafeInstance();
            valueOffset = unsafe.objectFieldOffset(CASLock.class.getDeclaredField("value"));
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    private static Unsafe getUnsafeInstance() throws SecurityException,
            NoSuchFieldException, IllegalArgumentException,
            IllegalAccessException {
        Field theUnsafeInstance = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafeInstance.setAccessible(true);
        return (Unsafe) theUnsafeInstance.get(Unsafe.class);
    }

    public void incr() {
        while (true) {
            int temp = value;
            if (unsafe.compareAndSwapInt(this, valueOffset, temp, temp + 1)) {
                break;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(100);
        CASLock casLock = new CASLock();

//        AtomicInteger atomicInteger = new AtomicInteger(0);

        for (int i = 0; i < 10000000; i++) {
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    casLock.incr();
//                    atomicInteger.incrementAndGet();
                }
            });
        }

        pool.shutdown();

        Thread.sleep(5000);
        System.out.println(casLock.value);
//        System.out.println(atomicInteger.get());
    }

}
