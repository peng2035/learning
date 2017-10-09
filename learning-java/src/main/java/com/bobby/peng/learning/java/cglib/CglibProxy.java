package com.bobby.peng.learning.java.cglib;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by bobby.peng on 2017/8/29.
 */
public class CglibProxy implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("begin");
        Object invoke = methodProxy.invoke(new CglibTest(),objects);
        System.out.println("end");
        return invoke;
    }

    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/peng2035/git/learning/target/classes/com/bobby/peng/learning/cglib/aaaa");

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(CglibTest.class);
        enhancer.setCallback(new CglibProxy());
        CglibTest userService = (CglibTest) enhancer.create();
        userService.proxy();
        System.out.println(1111);
    }
}
