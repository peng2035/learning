package com.bobby.peng.learning.spring.retryable;

import org.springframework.retry.annotation.Retryable;

/**
 * Created by bobby.peng on 29/12/2017.
 */
public class RetryableInterceptorService {

    private int count = 0;

    @Retryable(interceptor = "retryInterceptor")
    public void service() {
        if (count++ < 4) {
            throw new RuntimeException("Planned");
        }
    }

    public int getCount() {
        return count;
    }

}
