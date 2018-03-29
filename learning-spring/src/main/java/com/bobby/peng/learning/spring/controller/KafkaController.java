package com.bobby.peng.learning.spring.controller;

import com.bobby.peng.learning.spring.kafka.Listener;
import com.bobby.peng.learning.spring.service.KafkaService;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by bobby.peng on 28/03/2018.
 */
@Controller
@RequestMapping("/kafka")
public class KafkaController {

    @Autowired
    private KafkaService kafkaService;

    @RequestMapping("/produce")
    @ResponseBody
    public void produce() {

        kafkaService.randomProduce();
    }
}
