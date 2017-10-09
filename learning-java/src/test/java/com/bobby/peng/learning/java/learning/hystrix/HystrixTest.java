package com.bobby.peng.learning.java.learning.hystrix;

import org.junit.Test;
import rx.Observable;
import rx.Observer;

import static org.junit.Assert.assertEquals;

/**
 * Created by peng2035 on 2017/3/25.
 */
public class HystrixTest {

    @Test
    public void testHelloHystrix() {
//        HystrixCommandHelloWorld helloHystrix = new HystrixCommandHelloWorld("World");
//        String result = helloHystrix.execute();
//
//        assertEquals("Hello World, Failure", result);

    }

    @Test
    public void testHelloHystrixObservable() {
//        HystrixObservableCommandHelloWorld helloHystrix = new HystrixObservableCommandHelloWorld("World");
//        Observable<String> observable = helloHystrix.observe();
//        observable.subscribe(new Observer<String>() {
//            public void onCompleted() {
//                System.out.println("completed");
//            }
//            public void onError(Throwable e) {
//                e.printStackTrace();
//            }
//            public void onNext(String s) {
//
//                assertEquals("Hello World, Failure", s);
//
//            }
//        });
    }

    public static void main(String[] args) {
        System.out.println(Integer.valueOf("9646324351"));
    }

}
