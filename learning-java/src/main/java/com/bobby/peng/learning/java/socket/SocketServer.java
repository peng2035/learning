package com.bobby.peng.learning.java.socket;

import com.bobby.peng.learning.java.socket.utils.SocketServerUtils;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.net.ServerSocket;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by bobby.peng on 2016/12/25.
 */
public class SocketServer {

    public static ConcurrentHashMap<Integer, ServerSocket> serverSocketMap;

    static {
        serverSocketMap = new ConcurrentHashMap<>();
        for (int i = 0; i < 10; i++) {
            try {
                serverSocketMap.put(i, new ServerSocket(i + 8080));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {

        int size = SocketServer.serverSocketMap.size();
        ExecutorService pool = Executors.newFixedThreadPool(10);

        for (int i = 0; i < size; i++) {
            int i1 = i;
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        SocketServerUtils.solveSocket(serverSocketMap.get(i1));
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

}
