package com.bobby.peng.learning.sync;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.ByteArrayRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;

import java.io.*;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by bobby.peng on 2016/10/8.
 */
public class SyncTest {
    private final static int READ_BODY_SIZE = 5120;

    public void test() {
        synchronized (this) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("notify all :" + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
                System.out.println("notify all after sleep:" + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void notified() {
        synchronized (this) {
            this.notifyAll();
        }
    }
}
