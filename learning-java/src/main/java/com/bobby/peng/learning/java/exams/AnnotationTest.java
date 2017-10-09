package com.bobby.peng.learning.java.exams;

import com.bobby.peng.learning.java.annoation.Annotation;
import com.bobby.peng.learning.java.annoation.AnnotationOut;

/**
 *
 *
 * @author <a href="mailto:peng2035@163.com">彭天浩</a>
 * @version 1.0
 */
@AnnotationOut
@Annotation
public class AnnotationTest {


    public static void main(String[] args) {
        AnnotationTest annotationTest = new AnnotationTest();

       java.lang.annotation.Annotation[] annotations = annotationTest.getClass().getAnnotations();

       System.out.println(annotations);
    }
}
