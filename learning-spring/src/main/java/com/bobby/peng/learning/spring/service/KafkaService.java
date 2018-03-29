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

    public void randomProduce() {
        String key = String.valueOf(RandomUtils.nextInt());
        String value = String.valueOf(RandomUtils.nextInt());
        log.info("produce topic : pengtianhao-test,key:{},value:{}", key, value);
        template.send("pengtianhao-test", key, value);
    }

}
