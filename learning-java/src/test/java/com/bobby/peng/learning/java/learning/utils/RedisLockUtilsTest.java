package com.bobby.peng.learning.java.learning.utils;

import com.bobby.peng.learning.java.basic.utils.RedisLockUtils;
import com.bobby.peng.learning.java.learning.AbstractTestCase;
import org.junit.Ignore;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by peng2035 on 16-12-5.
 */
public class RedisLockUtilsTest extends AbstractTestCase {

//    @Autowired
    private RedisLockUtils redisLockUtils;

    private AtomicInteger getLockCount = new AtomicInteger(0);

    private AtomicInteger unGetLockCount = new AtomicInteger(0);

    @org.junit.Test
    @Ignore
    public void test() {
        ExecutorService threadPool = Executors.newFixedThreadPool(100);
        CountDownLatch countDownLatch = new CountDownLatch(100);

        for (int i = 0; i < 100; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    String uuid = null;
                    try {
                        uuid = redisLockUtils.acquireLock("redisLockTest", 10000, 50);

                        if (uuid != null) {
                            getLockCount.addAndGet(1);
                        } else {
                            unGetLockCount.addAndGet(1);
                        }
                    } finally {
                        redisLockUtils.unlock("redisLockTest",uuid);
                        countDownLatch.countDown();
                    }

                }
            });
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("get lock count : " + getLockCount);
        System.out.println("un get lock count : " + unGetLockCount);

    }
}
