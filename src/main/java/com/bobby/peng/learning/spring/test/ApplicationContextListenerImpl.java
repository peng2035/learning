package com.bobby.peng.learning.spring.test;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.stereotype.Service;

/**
 * Created by bobby.peng on 2017/3/14.
 */
public class ApplicationContextListenerImpl implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextStartedEvent) {
        System.out.println(111);
    }

}
