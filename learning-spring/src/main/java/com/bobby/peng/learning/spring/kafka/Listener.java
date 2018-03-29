package com.bobby.peng.learning.spring.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


/**
 * Created by bobby.peng on 28/03/2018.
 */
public class Listener {

    @KafkaListener(topics = "pengtianhao-test",groupId = "pengtianhao-test-group-1")
    public void listen(ConsumerRecord<?, ?> cr) {
        System.out.println("listen1 : " + cr.toString());
    }


    @KafkaListener(topics = "pengtianhao-test",groupId = "pengtianhao-test-group-4")
    public void listen2(ConsumerRecord<?, ?> cr) {
        System.out.println("listen2 : " + cr.toString());
    }
}
