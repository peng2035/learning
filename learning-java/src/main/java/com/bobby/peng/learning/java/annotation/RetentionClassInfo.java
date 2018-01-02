package com.bobby.peng.learning.java.annotation;

import com.bobby.peng.learning.annotation.RetentionClassAnnotation;

/**
 * Created by bobby.peng on 02/01/2018.
 */
@RetentionClassAnnotation
public class RetentionClassInfo {

    public static void main(String[] args) {
        System.out.println("start");
        RetentionClassInfo retentionClassInfo = new RetentionClassInfo();
        System.out.println("end");
    }

}
