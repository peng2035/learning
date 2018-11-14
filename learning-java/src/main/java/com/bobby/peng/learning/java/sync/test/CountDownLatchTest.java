package com.bobby.peng.learning.java.sync.test;

import lombok.ToString;
import org.apache.commons.lang.math.RandomUtils;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author <a href="mailto:peng2035@163.com">彭天浩</a>
 * @version 1.0
 */
public class CountDownLatchTest {

    private int value;

    public CountDownLatchTest(int value) {
        this.value = value;
    }

    public synchronized void countDown() {
        value--;

        if (value <= 0) {
            this.notifyAll();
            System.out.println("notify : " + Thread.currentThread());
        }
    }

    public synchronized void await() throws InterruptedException {
        if (value > 0) {
            System.out.println("in wait");
            this.wait();
            System.out.println("await : " + Thread.currentThread());
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        CountDownLatchTest countDownLatch = new CountDownLatchTest(5);
//
//        ExecutorService pool = Executors.newFixedThreadPool(10);
//
//        System.out.println(Thread.currentThread());
//        for (int i = 0; i < 6; i++) {
//            int finalI = i;
//            pool.submit(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        Thread.sleep(finalI * 1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    countDownLatch.countDown();
//
//                    System.out.println("i : " + finalI);
//                    try {
//                        countDownLatch.await();
//                        System.out.println("i : " + finalI + " after await");
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
////                    System.out.println(Thread.currentThread());
//                }
//            });
//        }
//
//        pool.shutdown();


//      在最后一个count down 执行之后，之前成功的await的线程就可以开始执行了，而不需要等待到最后一根线程到await状态
//        CountDownLatch latch = new CountDownLatch(5);
//
//        for (int i = 0; i < 100; i++) {
//            pool.execute(new Runnable() {
//                @Override
//                public void run() {
//                    latch.countDown();
//
//                    System.out.println("count down after sleep");
//
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//                }
//            });
//        }
//
//        latch.await();
//
//
//        System.out.println("latch after await");
//        pool.shutdown();

        testCountDownAndAwaitInSameThread();
    }

    public static void testCountDownAndAwaitInSameThread() throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(10);

        CopyOnWriteArraySet set = new CopyOnWriteArraySet();

        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            try {
                Thread.sleep(RandomUtils.nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            pool.submit(() -> {
                Man man = new Man();
                countDownLatch.countDown();
                try {
                    countDownLatch.await();
                    System.out.println("id : " + finalI + " , start running");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                man.id = finalI;
                man.start = System.currentTimeMillis();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                man.end = System.currentTimeMillis();
                set.add(man);
            });
        }

        pool.shutdown();
        pool.awaitTermination(1000, TimeUnit.SECONDS);

        set.forEach(man -> {
            System.out.println(man.toString());
        });
    }

    @ToString
    public static class Man {
        public long id;

        public long start;

        public long end;


    }
}
