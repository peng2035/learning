package com.bobby.peng.learning.java.spring.test;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * Created by bobby.peng on 2017/3/14.
 */
public class ApplicationContextListenerImpl implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextStartedEvent) {
        System.out.println(111);
    }

}
