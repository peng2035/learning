package com.bobby.peng.learning.java.mq;


import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

/**
 * <p>2017/3/21</p>
 *
 * @author <a href="mailto:peng2035@163.com">彭天浩</a>
 * @version 1.0
 */
public class UnAckTestListener implements MessageListener {

    @Override
    public void onMessage(Message message) {
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {

        }

        throw new RuntimeException();
    }
}
