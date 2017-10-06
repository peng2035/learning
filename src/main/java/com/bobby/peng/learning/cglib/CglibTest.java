package com.bobby.peng.learning.cglib;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by bobby.peng on 2017/8/29.
 */
public class CglibTest {

    public void proxy() {
        System.out.println("do proxy");
    }

}
