package com.bobby.peng.learning.java.mq;

import com.alibaba.fastjson.JSON;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * <p>2017/3/21</p>
 *
 * @author <a href="mailto:peng2035@163.com">彭天浩</a>
 * @version 1.0
 */
@Component
public class TestSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("#{rabbitmq['exchange']}")
    private String exchange;

    @Value("#{rabbitmq['routing.key']}")
    private String routingKey;

    public void send() {
        System.out.println("send start");
        amqpTemplate.convertAndSend(exchange, routingKey, JSON.toJSON(new Object()));
    }

}
