package com.bobby.peng.learning.java.proxy.cglib;

import com.bobby.peng.learning.java.proxy.cglib.guess.GuessedCglibProxy;
import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

/**
 * Created by bobby.peng on 03/01/2018.
 */
public class SimpleCglibService {

    public void method1() {
        System.out.println("SimpleCglibService in method1");
        method2();
    }

    public void method2() {
        System.out.println("SimpleCglibService in method2");
    }

    public static void main(String[] args) {
//        GuessedCglibProxy guessedCglibProxy = new GuessedCglibProxy();
//        guessedCglibProxy.method1();

        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/peng2035/git/learning/learning-java/target/classes/com/bobby/peng/learning/java/proxy/cglib/");

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SimpleCglibService.class);
        enhancer.setCallback(new CglibProxy());
        SimpleCglibService simpleCglibService = (SimpleCglibService) enhancer.create();
        simpleCglibService.method1();

    }
}
