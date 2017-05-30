package com.bobby.peng.learning.sync;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
        CountDownLatchTest countDownLatch = new CountDownLatchTest(5);

        ExecutorService pool = Executors.newFixedThreadPool(10);

        System.out.println(Thread.currentThread());
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
        CountDownLatch latch = new CountDownLatch(5);

        for (int i = 0; i < 100; i++) {
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    latch.countDown();

                    System.out.println("count down after sleep");

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            });
        }

        latch.await();


        System.out.println("latch after await");
        pool.shutdown();
    }
}
