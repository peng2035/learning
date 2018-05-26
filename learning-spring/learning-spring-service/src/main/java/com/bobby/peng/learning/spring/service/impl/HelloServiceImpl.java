package com.bobby.peng.learning.spring.service.impl;

import com.bobby.peng.learning.spring.service.api.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * Created by bobby.peng on 2018/4/28.
 */
@Slf4j
public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHello() {
        log.info("hello world");
    }
}
