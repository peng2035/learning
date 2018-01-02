package com.bobby.peng.learning.java.annotation;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by bobby.peng on 02/01/2018.
 */
//允许子类（仅限于类）继承父类的注解
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface InheritedAnnotation {

    int value() default 1;

}
