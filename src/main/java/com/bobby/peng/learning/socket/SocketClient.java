package com.bobby.peng.learning.socket;

import com.alibaba.fastjson.JSON;

import java.io.*;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by bobby.peng on 2016/12/25.
 */
public class SocketClient {

    public static void main(String[] args) throws IOException {
        ExecutorService pool = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Socket socket = new Socket("127.0.0.1", 8080);
                        SocketEntity socketEntity = new SocketEntity(finalI, "com.bobby.peng.learning.socket.ServiceTestImpl", "print");

                        System.out.println("client " + finalI + "start : do write");
                        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"));
                        bw.write(JSON.toJSONString(socketEntity) + "\n");
                        bw.flush();

                        System.out.println("=========hello============");

                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
                        System.out.println("message from server:" + bufferedReader.readLine());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

}
