package com.bobby.peng.learning.sync.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author <a href="mailto:peng2035@163.com">彭天浩</a>
 * @version 1.0
 */
public class ReadWriteLockTest {

    private final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock(false);

    private final Lock rLock = readWriteLock.readLock();

    private final Lock wLock = readWriteLock.writeLock();

    public void read() {
        try {
            rLock.lock();

            System.out.println(Thread.currentThread() + " in read , timestamp : " + System.currentTimeMillis());

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } finally {
            System.out.println(Thread.currentThread() + " in read finished , timestamp : " + System.currentTimeMillis());
            rLock.unlock();
        }
    }

    public void write() throws InterruptedException {
        try {
            wLock.lock();

            System.out.println(Thread.currentThread() + " in write , timestamp : " + System.currentTimeMillis());

            Thread.sleep(5000);
        } finally {
            System.out.println(Thread.currentThread() + " in write finished , timestamp : " + System.currentTimeMillis());
            wLock.unlock();
        }
    }

    public Lock getrLock() {
        return rLock;
    }

    public Lock getwLock() {
        return wLock;
    }

    public static void main(String[] args) {
        ReadWriteLockTest readWriteLockTest = new ReadWriteLockTest();

//        ExecutorService rpool = Executors.newFixedThreadPool(10);
//        ExecutorService wpool = Executors.newFixedThreadPool(10);
//
//        for(int i=0;i<5;i++) {
//            rpool.submit(() -> {
//                readWriteLockTest.read();
//            });
//        }
//
//
//        for(int i=0;i<5;i++) {
//            wpool.submit(() -> {
//                try {
//                    readWriteLockTest.write();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            });
//        }
//
//        rpool.shutdown();
//        wpool.shutdown();

        //测试同一线程下的写锁释放的情况下，读锁在可重入情况下没有完全释放，其他线程能否获得锁。
        //锁降级成读锁，但是和其他锁还是互斥
//        new Thread(() -> {
//            try {
//                readWriteLockTest.getwLock().lock();
//                System.out.println(Thread.currentThread() + "get write lock ");
//                readWriteLockTest.getrLock().lock();
//                System.out.println(Thread.currentThread() + "get read lock");
//
//                readWriteLockTest.getrLock().lock();
//                System.out.println(Thread.currentThread() + "get read lock");
//
//                readWriteLockTest.getrLock().lock();
//                System.out.println(Thread.currentThread() + "get read lock");
//            } finally {
//                readWriteLockTest.getwLock().unlock();
//                System.out.println(Thread.currentThread() + "write lock unlock");
//
//                try {
//                    Thread.sleep(5000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//                for (int i = 0; i < 3; i++) {
//                    readWriteLockTest.getrLock().unlock();
//                }
//                System.out.println(Thread.currentThread() + "read lock unlock");
//            }
//
//        }).start();
//
//        new Thread(() -> {
//            try {
//                readWriteLockTest.getwLock().lock();
//                System.out.println(Thread.currentThread() + "get write lock ");
//            } finally {
//                readWriteLockTest.getwLock().unlock();
//                System.out.println(Thread.currentThread() + "write lock unlock");
//            }
//        }).start();
//
//        new Thread(() -> {
//            try {
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                readWriteLockTest.getrLock().lock();
//                System.out.println(Thread.currentThread() + "get read lock ");
//            } finally {
//                readWriteLockTest.getrLock().unlock();
//                System.out.println(Thread.currentThread() + "read lock unlock");
//            }
//        }).start();


//        ExecutorService readPool = Executors.newFixedThreadPool(10);



        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    readWriteLockTest.write();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


        try {
            System.out.println("before main thread , timestamp : " + System.currentTimeMillis());
            Thread.sleep(200);
            System.out.println("after main thread , time stamp : " + System.currentTimeMillis());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(int i=0;i<5;i++) {

//            readPool.execute(new Runnable() {
//                @Override
//                public void run() {
//                    readWriteLockTest.read();
//                }
//            });

            new Thread(() -> {
                readWriteLockTest.read();
            }).start();

            System.out.println("current i : " + i);
        }

    }

}
