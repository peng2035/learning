package com.bobby.peng.learning.java.proxy.javadynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by bobby.peng on 03/01/2018.
 */
public class SimpleServiceProxyHandler implements InvocationHandler {
    private Object target;

    public SimpleServiceProxyHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("in proxy, class : " + target.getClass().getName() + " ,method : " + method.getName());
        return method.invoke(target, args);
    }
}
