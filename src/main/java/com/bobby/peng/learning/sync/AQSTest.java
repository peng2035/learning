package com.bobby.peng.learning.sync;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 *
 *
 * @author <a href="mailto:peng2035@163.com">彭天浩</a>
 * @version 1.0
 */
public class AQSTest extends AbstractQueuedSynchronizer {

    //arg 表示可重入的次数
    @Override
    protected final boolean tryAcquire(int arg) {
        final Thread current = Thread.currentThread();

        //todo AbstractOwnableSynchronizer读写为何不需要加锁
        int c = getState();
        //没有对象获得锁
        if (c == 0) {
            if (compareAndSetState(0, arg)) {
                setExclusiveOwnerThread(Thread.currentThread());
            }
        } else if(current == getExclusiveOwnerThread()){
            //重入锁
            //单线程状态不用判断是否是多线程
            int nextc = c + arg;
            if(nextc < 0) { //overflow
                throw new RuntimeException("max lock");
            }

            setState(nextc);
            return true;
        }

        return false;
    }

    @Override
    protected boolean tryRelease(int arg) {
        return super.tryRelease(arg);  // TODO
    }
}
