package com.bobby.peng.learning.spring.scheduler;

import com.bobby.peng.learning.java.basic.utils.RedisUtils;
import com.bobby.peng.learning.spring.service.KafkaService;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by bobby.peng on 29/03/2018.
 */
@Component
public class TaskScheduler {

    @Autowired
    private KafkaService kafkaService;

    @Scheduled(cron = "*/1 * * * * ?")
    public void start() {
        for(int i=0;i<10000;i++) {
            kafkaService.randomProduce("pengtianhao-test");
            kafkaService.randomProduce("pengtianhao-test-2");
        }
    }

}
