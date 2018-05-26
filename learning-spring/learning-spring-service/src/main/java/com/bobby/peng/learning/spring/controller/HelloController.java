package com.bobby.peng.learning.spring.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by bobby.peng on 2018/4/21.
 */
@RestController
@Slf4j
public class HelloController {

    @RequestMapping(value = "/hello")
    public String sayHello() {
        String hello = "hello";
        log.info(hello);
        return hello;
    }

}
