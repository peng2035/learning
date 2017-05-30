package com.bobby.peng.learning.controller;

import com.bobby.peng.learning.mq.TestSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>2017/3/21</p>
 *
 * @author <a href="mailto:peng2035@163.com">彭天浩</a>
 * @version 1.0
 */
@Controller
public class MqTestController {

    @Autowired
    private TestSender testSender;

    @RequestMapping(value = "/mq", method = RequestMethod.GET)
    public void test() {
        ExecutorService pool = Executors.newFixedThreadPool(5);

        for(int i=0;i<20;i++) {
            pool.execute(() -> {
                testSender.send();
            });
        }

        pool.shutdown();
        return;
    }

}
