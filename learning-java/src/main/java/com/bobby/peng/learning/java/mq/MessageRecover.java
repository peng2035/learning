package com.bobby.peng.learning.java.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.retry.MessageRecoverer;

/**
 * Created by alice.jin on 2015/12/29.
 */
public class MessageRecover implements MessageRecoverer {

    private static Logger logger = LoggerFactory.getLogger(MessageRecover.class);

    @Override
    public void recover(Message message, Throwable throwable) {
        logger.error("MQ error, msg:{}", new String(message.getBody()), throwable);
        throw new AmqpRejectAndDontRequeueException(throwable);
    }
}
