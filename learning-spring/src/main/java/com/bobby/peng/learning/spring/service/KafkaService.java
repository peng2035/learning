package com.bobby.peng.learning.spring.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by bobby.peng on 29/03/2018.
 */
@Service
@Slf4j
public class KafkaService {

    @Autowired
    private KafkaTemplate<String, String> template;

    private static ThreadLocal<Integer> num = ThreadLocal.withInitial(() -> 0);

    public void randomProduce(String topic) {
        String key = String.valueOf(RandomUtils.nextInt());
        String value = String.valueOf(RandomUtils.nextInt());
        if(num.get() == 1000) {
            log.info("produce topic:{},key:{},value:{}", topic, key, value);
            num.set(0);
        } else {
            num.set(num.get()+1);
        }
        template.send(topic, key, value);
    }

}
