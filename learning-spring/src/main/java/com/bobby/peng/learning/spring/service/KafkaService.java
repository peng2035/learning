package com.bobby.peng.learning.spring.service;

import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by bobby.peng on 29/03/2018.
 */
@Service
public class KafkaService {

    @Autowired
    private KafkaTemplate<String, String> template;

    public void randomProduce() {
        template.send("pengtianhao-test",String.valueOf(RandomUtils.nextInt()),String.valueOf(RandomUtils.nextInt()));
        template.flush();
    }

}
