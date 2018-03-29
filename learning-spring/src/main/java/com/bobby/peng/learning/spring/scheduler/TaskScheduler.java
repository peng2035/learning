package com.bobby.peng.learning.spring.scheduler;

import com.bobby.peng.learning.spring.service.KafkaService;
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
        for(int i=0;i<5;i++) {
//            kafkaService.randomProduce();
        }
    }

}
