package com.bobby.peng.learning.processor;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.util.Set;

/**
 * Created by bobby.peng on 02/01/2018.
 */
//编译时注解。至今没跑通 todo
@SupportedAnnotationTypes("com.bobby.peng.learning.java.annotation.RetentionClassAnnotation")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class RetentionClassAnnotationProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        System.out.println("RetentionClassAnnotationProcessor work");
        Messager messager = this.processingEnv.getMessager();
        messager.printMessage(Diagnostic.Kind.ERROR,"RetentionClassAnnotationProcessor work");

        return true;
    }




}
