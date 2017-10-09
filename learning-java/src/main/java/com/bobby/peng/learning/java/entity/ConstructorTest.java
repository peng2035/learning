package com.bobby.peng.learning.java.entity;

/**
 * Created by bobby.peng on 2017/9/16.
 */
public class ConstructorTest {

    private String proxyServer;

    private int port;

    private long timeout;

    public ConstructorTest(String proxyServer, int port, long timeout) {
        this.proxyServer = proxyServer;
        this.port = port;
        this.timeout = timeout;
    }
}
