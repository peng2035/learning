package com.bobby.peng.learning.java.disruptor;

import com.lmax.disruptor.EventHandler;

public class LongEventHandler implements EventHandler<LongEvent> {

    @Override
    public void onEvent(LongEvent longEvent, long l, boolean b) throws Exception {
        Thread.sleep(1000);
        System.out.println(Thread.currentThread() + ", Event : " + longEvent.getValue());
    }

    class InnerLongEventHandler implements EventHandler<LongEvent> {
        @Override
        public void onEvent(LongEvent longEvent, long l, boolean b) throws Exception {
            Thread.sleep(800);

            System.out.println(Thread.currentThread() + ", Inner event : " + longEvent.getValue());
        }
    }

    class WorkEventHandler implements com.lmax.disruptor.WorkHandler<LongEvent> {

        @Override
        public void onEvent(LongEvent longEvent) throws Exception {
            System.out.println("todo" + longEvent.getValue());
            Thread.sleep(10000);
        }
    }
}
