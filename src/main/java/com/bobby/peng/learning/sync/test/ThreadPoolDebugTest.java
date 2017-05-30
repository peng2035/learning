package com.bobby.peng.learning.sync.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 *
 * @author <a href="mailto:peng2035@163.com">彭天浩</a>
 * @version 1.0
 */
public class ThreadPoolDebugTest {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(1);

        for (int i = 0; i < 5; i++) {
            service.submit(() -> {
                System.out.println("hello");
            });
        }

        service.shutdown();
    }

}
