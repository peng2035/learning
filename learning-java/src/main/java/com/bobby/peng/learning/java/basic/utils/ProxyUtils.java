package com.bobby.peng.learning.java.basic.utils;

import java.io.FileOutputStream;
import java.io.IOException;

import sun.misc.ProxyGenerator;

/**
 * Created by bobby.peng on 2017/8/27.
 */
public class ProxyUtils {

    public static void generateClassFile(Class clazz, String proxyName) {
        String paths = clazz.getResource(".").getPath();
        System.out.println(paths);
        generateClassFile(clazz, proxyName, paths);
    }

    public static void generateClassFile(Class clazz, String proxyName, String paths) {
        byte[] classFile = ProxyGenerator.generateProxyClass(proxyName, clazz.getInterfaces());
        FileOutputStream out = null;

        try {
            out = new FileOutputStream(paths + proxyName + ".class");
            out.write(classFile);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
