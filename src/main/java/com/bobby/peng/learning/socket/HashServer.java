package com.bobby.peng.learning.socket;

import com.bobby.peng.learning.socket.utils.HashServerUtils;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by bobby.peng on 2016/12/25.
 */
public class HashServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);

        ExecutorService pool = Executors.newFixedThreadPool(10);
        while (true) {

            Socket socket = serverSocket.accept();

            pool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Socket remoteSocket = new Socket("127.0.0.1", HashServerUtils.getPort());

                        HashServerUtils.transformData(socket, remoteSocket,true);
                        HashServerUtils.transformData(remoteSocket, socket,false);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            });
        }
    }
}
