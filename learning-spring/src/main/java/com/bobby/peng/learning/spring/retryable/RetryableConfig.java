package com.bobby.peng.learning.spring.retryable;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by bobby.peng on 29/12/2017.
 */
@Configuration
public class RetryableConfig {

    @Bean
    public RetryableLogInterceptor interceptor() {
        return null;
    }

}
