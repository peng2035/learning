package com.bobby.peng.learning.java.socket.utils;

import com.alibaba.fastjson.JSON;
import com.bobby.peng.learning.java.socket.SocketEntity;
import com.bobby.peng.learning.java.socket.proxy.DynamicProxy;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by bobby.peng on 2016/12/25.
 */
public class SocketServerUtils {

    public static void solveSocket(ServerSocket serverSocket) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        while(true) {
            System.out.println("端口 " + serverSocket + "启动");
            Socket socket = serverSocket.accept();
//
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));

            String entityJson = bufferedReader.readLine();
            SocketEntity socketEntity = JSON.parseObject(entityJson,SocketEntity.class);

            System.out.println("端口：" + serverSocket.getLocalPort() + "开始执行: 第" + socketEntity.getId() + "个客户端");

            Class clazz = Class.forName(socketEntity.getClassName());
            Object o = clazz.newInstance();
            Object proxy = Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),new DynamicProxy(o));

            Method method = proxy.getClass().getMethod(socketEntity.getMethodName());
            Object o2 = method.invoke(proxy);

            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"));
            bufferedWriter.write(o2.toString()+"\n");
            bufferedWriter.flush();
        }

    }

}
