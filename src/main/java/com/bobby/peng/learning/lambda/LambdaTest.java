package com.bobby.peng.learning.lambda;

/**
 * Created by bobby.peng on 2016/11/3.
 */
public class LambdaTest {

    public void print(LambdaInterface lambdaInterface) {
        lambdaInterface.run(1);
    }

//    public void print(int a) {
//        System.out.println(a);
//    }

    public static void main(String[] args) {
        LambdaTest lambdaTest = new LambdaTest();

        lambdaTest.print(a -> System.out.println(a));

        lambdaTest.print(System.out::println);
    }
}
