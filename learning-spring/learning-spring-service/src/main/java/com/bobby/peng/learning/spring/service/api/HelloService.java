package com.bobby.peng.learning.spring.service.api;

import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * Created by bobby.peng on 2018/4/28.
 */
@FeignClient("hello-service")
public interface HelloService {

    void sayHello();

}
