package com.bobby.peng.learning.java.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by peng2035 on 2017/3/25.
 */
public class HystrixCommandHelloWorld extends HystrixCommand<String> {

    private String somebody;

    private static AtomicInteger atomicInteger = new AtomicInteger();

    private static AtomicInteger fallbackAtomicInteger = new AtomicInteger();

    public HystrixCommandHelloWorld(String somebody) {

        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("hello")));
        this.somebody = somebody;
    }

    protected String run() throws Exception {

        atomicInteger.addAndGet(1);
        //生产环境中此处为第三方依赖的具体调用逻辑
        return new StringBuilder().append("Hello ").append(somebody).toString();
    }

    @Override
    protected String getFallback() {
        fallbackAtomicInteger.addAndGet(1);
        return "fallback " + this.somebody;
    }

    public static void main(String[] args) throws InterruptedException {
        for(int i=0;i<100;i++) {
            new Thread(() -> {
                new HystrixCommandHelloWorld("hello world").execute();
            }).start();
        }

        TimeUnit.SECONDS.sleep(10);
        System.out.println("execute : " + atomicInteger.get());
        System.out.println("fallback : " + fallbackAtomicInteger.get());
    }
}
