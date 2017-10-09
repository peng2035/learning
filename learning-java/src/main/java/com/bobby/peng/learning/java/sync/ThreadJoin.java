package com.bobby.peng.learning.java.sync;

/**
 *
 *
 * @author <a href="mailto:peng2035@163.com">彭天浩</a>
 * @version 1.0
 */
public class ThreadJoin {

    private class JoinThread implements Runnable{
        private Thread thread;

        public JoinThread(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                if(thread != null) {
                    thread.join();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(thread.getName());
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        ThreadJoin threadJoin = new ThreadJoin();

        System.out.println(Thread.currentThread().getName());
        Thread previous = Thread.currentThread();
        for(int i = 0;i<10;i++) {
            JoinThread joinThread = threadJoin.new JoinThread(previous);
            Thread thread = new Thread(joinThread,String.valueOf(i));
            previous = thread;
            thread.start();
        }
    }

}
