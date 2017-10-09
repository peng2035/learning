package com.bobby.peng.learning.java.socket.utils;

import java.io.*;
import java.net.Socket;
import java.util.Random;

/**
 * Created by bobby.peng on 2016/12/25.
 */
public class HashServerUtils {

    public static Random random = new Random();

    public static int getPort() {
        int num = random.nextInt(10);
        return num + 8081;
    }

    public static void transformData(Socket socket, Socket outputSocket, boolean flag) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputSocket.getOutputStream(), "UTF-8"));
        String value = bufferedReader.readLine();

        bufferedWriter.write(value + "\n");
        bufferedWriter.flush();
        if (flag) {
            System.out.println("succeed to send value : " + value);
        } else {
            System.out.println("succeed to receive value : " + value);
        }
    }

}
