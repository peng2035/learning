package com.bobby.peng.learning.java.annotation;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Method;

/**
 * Created by bobby.peng on 02/01/2018.
 */
public class InheritedClass extends AbstractInheritedClass {

    public static void main(String[] args) throws NoSuchMethodException {
        InheritedClass inheritedClass = new InheritedClass();

        InheritedAnnotation annotation = inheritedClass.getClass().getAnnotation(InheritedAnnotation.class);

        //@Inherited 注解仅限于类
        if(annotation == null) {
            System.out.println("can't get annotation from parent class");
        } else {
            System.out.println("get annotation from parent class, value = " + annotation.value());
        }
    }
}
