package com.bobby.peng.learning.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * Created by peng2035 on 2017/3/25.
 */
public class HystrixCommandHelloWorld extends HystrixCommand<String> {

    private String somebody;

    public HystrixCommandHelloWorld(String somebody) {

        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("hello")));
        this.somebody = somebody;
    }

    protected String run() throws Exception {

        //生产环境中此处为第三方依赖的具体调用逻辑
        return new StringBuilder().append("Hello ").append(somebody).toString();
    }


}
