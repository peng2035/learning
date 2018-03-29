package com.bobby.peng.learning.spring.kafka;

import com.bobby.peng.learning.java.basic.utils.RedisUtils;
import com.netflix.discovery.converters.Auto;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


/**
 * Created by bobby.peng on 28/03/2018.
 */
@Slf4j
public class Listener {
    @Autowired
    private RedisUtils<String,String> redisUtils;

    @KafkaListener(topics = "pengtianhao-test",groupId = "pengtianhao-test-group-1")
    public void listen(ConsumerRecord<String, String> cr) {
        log.info("pengtianhao-test-group-1 : " + cr.toString());
        redisUtils.set(cr.key(),cr.value());
    }


    @KafkaListener(topics = "pengtianhao-test",groupId = "pengtianhao-test-group-4")
    public void listen2(ConsumerRecord<String, String> cr) {
        log.info("pengtianhao-test-group-4 : " + cr.toString());
        redisUtils.set(cr.key(),cr.value());
    }
}
