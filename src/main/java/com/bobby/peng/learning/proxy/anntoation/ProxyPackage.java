package com.bobby.peng.learning.proxy.anntoation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 *
 *
 * @author <a href="mailto:peng2035@163.com">彭天浩</a>
 * @version 1.0
 */
@Target(ElementType.TYPE)
public @interface ProxyPackage {

    String path() default "";

}
