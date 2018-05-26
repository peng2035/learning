package com.bobby.peng.learning.java.proxy.javadynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by bobby.peng on 03/01/2018.
 */
public class SimpleServiceProxy {

    public static <T> T proxy(final Class<T> interfaceClass, T target) {
        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class<?>[]{interfaceClass},
                new SimpleServiceProxyHandler(target));
    }

}
