package com.bobby.peng.learning.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;

/**
 * Created by bobby.peng on 28/03/2018.
 */
@EnableAutoConfiguration
@ComponentScan
@ImportResource("classpath:appcontext*.xml")
@SpringBootApplication
public class LearningApplication {

    public static void main(String[] args) throws Exception{
        SpringApplication.run(LearningApplication.class,args);
    }
}
