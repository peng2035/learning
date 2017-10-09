package com.bobby.peng.learning.java.sync;

/**
 * Created by peng2035 on 2017/4/1.
 */
public class DelayQueueTest {

//    public static void main(String[] args) throws InterruptedException {
//
//        long now = System.currentTimeMillis();
//        Random random = new Random(now);
//        DelayQueue<DelayedTest> queue = new DelayQueue<>();
//
//        for (int i = 0; i < 1; i++) {
//            queue.add(new DelayedTest(now + random.nextInt(100000)));
//        }
//
//        for(;;) {
//            System.out.println("take start : " + System.currentTimeMillis());
//            queue.poll();//阻塞
//            System.out.println("take end : " + System.currentTimeMillis());
//        }
//
//    }

    public static void main(String[] args) {
        Integer value = null;
        int i = value;

        System.out.println(i);
    }
}
