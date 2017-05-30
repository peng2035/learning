package com.bobby.peng.learning.proxy;

import org.springframework.stereotype.Component;

/**
 *
 *
 * @author <a href="mailto:peng2035@163.com">彭天浩</a>
 * @version 1.0
 */
@Component
public class AopClass {

    public void print() {
        System.out.println("in aop class, do print method");
    }

}
