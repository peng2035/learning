package com.bobby.peng.learning.java.disruptor;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;

import java.awt.*;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        Executor executor = Executors.newCachedThreadPool();

        LongEventFactory factory = new LongEventFactory();

        int bufferSize = 1024;

        Disruptor<LongEvent> disruptor = new Disruptor<>(factory, bufferSize, executor);


        // Connect the handler
        LongEventHandler longEventHandler = new LongEventHandler();
        disruptor.handleEventsWith(longEventHandler,longEventHandler.new InnerLongEventHandler());
        LongEventHandler.WorkEventHandler[] workEventHandlers = new LongEventHandler.WorkEventHandler[10];

        LongEventHandler.WorkEventHandler workEventHandle = longEventHandler.new WorkEventHandler();

        for (int i = 0; i < workEventHandlers.length; i++) {
            workEventHandlers[i] = workEventHandle;
        }
        disruptor.handleEventsWithWorkerPool(workEventHandlers);

        // Start the Disruptor, starts all threads running
        disruptor.start();

        // Get the ring buffer from the Disruptor to be used for publishing.
        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();

        LongEventProducer producer = new LongEventProducer(ringBuffer);

        ByteBuffer bb = ByteBuffer.allocate(8);
        for (long l = 0; l<100; l++)
        {
            System.out.println("publish : " + l);
            bb.putLong(0, l);
            producer.onData(bb);
            Thread.sleep(10);
        }
    }


}
