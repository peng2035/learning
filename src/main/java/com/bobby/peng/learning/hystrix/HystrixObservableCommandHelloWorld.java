package com.bobby.peng.learning.hystrix;

import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixObservableCommand;
import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;

/**
 * Created by peng2035 on 2017/3/25.
 */
public class HystrixObservableCommandHelloWorld extends HystrixObservableCommand<String> {

    private String somebody;

    public HystrixObservableCommandHelloWorld(String somebody) {

        super(HystrixCommandGroupKey.Factory.asKey("hello"));
        this.somebody = somebody;

    }

    @Override
    protected Observable<String> construct() {
        return Observable.create(

            (Observable.OnSubscribe<String>) subscriber -> {
                if (!subscriber.isUnsubscribed()) {
                    subscriber.onNext("Hello " + somebody);
                    subscriber.onCompleted();
                }
            }).subscribeOn(Schedulers.io());
    }
}
