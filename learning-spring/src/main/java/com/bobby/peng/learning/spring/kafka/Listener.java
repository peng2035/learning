package com.bobby.peng.learning.spring.kafka;

import com.bobby.peng.learning.java.basic.utils.RedisUtils;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.netflix.discovery.converters.Auto;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.LongAdder;


/**
 * Created by bobby.peng on 28/03/2018.
 */
@Slf4j
//@KafkaListener(topics = "pengtianhao-await-2",groupId = "pengtianhao-await-2-group-1")
public class Listener {
//    @Autowired
//    private RedisUtils<String, String> redisUtils;



    public static Map<String, LongAdder> map = Maps.newConcurrentMap();

    private final static String PENGTIANHAO_TEST_GROUP_1 = "pengtianhao-await-group-1";

    private final static String PENGTIANHAO_TEST_GROUP_2 = "pengtianhao-await-group-2";

    @KafkaListener(topics = "pengtianhao-await", group = PENGTIANHAO_TEST_GROUP_1)
    public void listen(ConsumerRecord<String, String> cr) {

        map.computeIfAbsent(PENGTIANHAO_TEST_GROUP_1, k -> new LongAdder()).increment();

        long value = map.get(PENGTIANHAO_TEST_GROUP_1).longValue();
        if ((value & 8191l) == 8191l) {
            log.info("listener : group id : {}, record : {} , value : {}", PENGTIANHAO_TEST_GROUP_1, cr.toString(), value);
        }
//        redisUtils.set(Thread.currentThread().getName(),cr.value());
//        set.add(Thread.currentThread());
    }

    @KafkaListener(topics = "pengtianhao-await", group = PENGTIANHAO_TEST_GROUP_2)
    public void listen2(ConsumerRecord<String, String> cr) {
        map.computeIfAbsent(PENGTIANHAO_TEST_GROUP_2, k -> new LongAdder()).increment();
        long value = map.get(PENGTIANHAO_TEST_GROUP_2).longValue();

        if ((value & 8191l) == 8191l) {
            log.info("listener : group id : {}, record : {} , value : {}", PENGTIANHAO_TEST_GROUP_2, cr.toString(), value);
        }
    }


//    @KafkaListener(topics = "pengtianhao-await",groupId = "pengtianhao-await-group-1")
//    public void listen2(ConsumerRecord<String, String> cr) {
//        log.info("pengtianhao-await-group-4 : " + cr.toString());
//        redisUtils.set(cr.key(),cr.value());
//    }



}
