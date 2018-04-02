package com.bobby.peng.learning.spring.kafka;

import com.bobby.peng.learning.java.basic.utils.RedisUtils;
import com.netflix.discovery.converters.Auto;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


/**
 * Created by bobby.peng on 28/03/2018.
 */
@Slf4j
//@KafkaListener(topics = "pengtianhao-test-2",groupId = "pengtianhao-test-2-group-1")
public class Listener {
    @Autowired
    private RedisUtils<String,String> redisUtils;

    public static Set<Thread> set = new HashSet<>();

    @KafkaListener(topics = "pengtianhao-test",groupId = "pengtianhao-test-group-1")
    public void listen(ConsumerRecord<String, String> cr) {
        log.info("pengtianhao-test-group-1 : " + cr.toString());
        redisUtils.set(Thread.currentThread().getName(),cr.value());
        set.add(Thread.currentThread());
    }

    @KafkaListener(topics = "pengtianhao-test",groupId = "pengtianhao-test-group-2")
    public void listen2(String value) {
        log.info("pengtianhao-test-group-2 : " + value);
    }


//    @KafkaListener(topics = "pengtianhao-test",groupId = "pengtianhao-test-group-1")
//    public void listen2(ConsumerRecord<String, String> cr) {
//        log.info("pengtianhao-test-group-4 : " + cr.toString());
//        redisUtils.set(cr.key(),cr.value());
//    }
}
