package com.bobby.peng.learning.spring.retryable;

import org.aopalliance.intercept.MethodInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.retry.annotation.Retryable;
import org.springframework.retry.interceptor.RetryInterceptorBuilder;

/**
 * Created by bobby.peng on 29/12/2017.
 */
public class RetryableLogInterceptor {

    public static final Logger log = LoggerFactory.getLogger(RetryableLogInterceptor.class);

    public MethodInterceptor retryInterceptor() {
        log.info("in retry method");

        return RetryInterceptorBuilder.stateless()
                .maxAttempts(5)
                .build();
    }

}
