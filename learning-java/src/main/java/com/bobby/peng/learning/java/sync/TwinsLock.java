package com.bobby.peng.learning.java.sync;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Created by bobby.peng on 2018/4/12.
 */
public class TwinsLock extends AbstractQueuedSynchronizer implements Lock {

    @Override
    protected int tryAcquireShared(int arg) {
        for (; ; ) {
            int state = getState();
            int permit = state - arg;

            if (permit < 0 || compareAndSetState(state, permit)) {
                return permit;
            }
        }
    }

    @Override
    protected boolean tryReleaseShared(int arg) {
        for (; ; ) {
            int state = getState();
            int permit = state + arg;

            if (permit < 0 || compareAndSetState(state, permit)) {
                return permit >= 0;
            }
        }
    }

    @Override
    public void lock() {
        acquireShared(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        releaseShared(1);
    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, @NotNull TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {

    }

    @NotNull
    @Override
    public Condition newCondition() {
        return null;
    }
}
