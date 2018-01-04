package com.bobby.peng.learning.java.proxy.javadynamicproxy;

import com.bobby.peng.learning.java.basic.utils.ProxyUtils;

import java.lang.reflect.Method;

/**
 * Created by bobby.peng on 03/01/2018.
 */
public class SimpleServiceImpl implements SimpleService {

    @Override
    public void method1() {
        System.out.println("do in method 1");
        method2();
    }

    @Override
    public void method2() {
        System.out.println("do in method 2");
    }

    public static void main(String[] args) throws Exception {
//        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        ProxyUtils.generateClassFile(SimpleServiceImpl.class, "SimpleServiceJavaDynamicProxy");

        SimpleService simpleService = new SimpleServiceImpl();
        SimpleService simpleServiceImpl = SimpleServiceProxy.proxy(SimpleService.class, simpleService);

        simpleServiceImpl.method1();
    }

}
