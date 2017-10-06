package com.bobby.peng.learning.disruptor;

import com.lmax.disruptor.EventHandler;

public class LongEventHandler implements EventHandler<LongEvent> {

    @Override
    public void onEvent(LongEvent longEvent, long l, boolean b) throws Exception {
        System.out.println("Event : " + longEvent.getValue());
    }

    class InnerLongEventHandler implements EventHandler<LongEvent> {
        @Override
        public void onEvent(LongEvent longEvent, long l, boolean b) throws Exception {
            System.out.println("Inner event : " + longEvent.getValue());
        }
    }
}
