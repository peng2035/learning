package com.bobby.peng.learning.java.sync;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 *
 * @author <a href="mailto:peng2035@163.com">彭天浩</a>
 * @version 1.0
 */
public class ConditionTest {

    private ReentrantLock reentrantLock = new ReentrantLock();

    private Condition condition = reentrantLock.newCondition();

    public void test() {
        try {
            reentrantLock.lock();

        } finally {
            reentrantLock.unlock();
        }
    }

}
