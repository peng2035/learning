package com.bobby.peng.learning.java.hystrix;

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

    public static void main(String[] args) throws InterruptedException {
        Observable<String> observable = Observable.create(
                (Observable.OnSubscribe<String>) subscriber -> {
                    if (!subscriber.isUnsubscribed()) {
                        subscriber.onNext("Hello ");
                        subscriber.onCompleted();
                    }
                });

        Subscriber<String> subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("mission completed");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                System.out.println(s);
            }
        };

        observable.subscribe(subscriber);

//        for(int i=0;i<100;i++) {
//            new Thread(()-> {
//                new HystrixObservableCommandHelloWorld("hello").observe();
//            });
//        }
////        for(;;) {
////            System.out.println(observable.take(1));
////        }
//
//        Thread.sleep(10000);
    }
}
