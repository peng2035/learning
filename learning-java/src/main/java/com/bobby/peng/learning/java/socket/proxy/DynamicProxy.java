package com.bobby.peng.learning.java.socket.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 *
 *
 * @author <a href="mailto:peng2035@163.com">彭天浩</a>
 * @version 1.0
 */
public class DynamicProxy implements InvocationHandler {

    private Object obj;

    public DynamicProxy(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("class : " + obj.getClass().getName());
        System.out.println("method : " + method.getName());
        System.out.println("params : " + args);

        Object result = method.invoke(obj, args);

        System.out.println("result : " + result.toString());

        return result;
    }
}
