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

    public static void main(String[] args) throws IOException {
//        ExecutorService executorService = Executors.newFixedThreadPool(1000);
//
//        SyncTest syncTest = new SyncTest();
//
//        for(int i=0;i<1000;i++) {
//            executorService.execute(new Runnable() {
//                @Override
//                public void run() {
//                    syncTest.test();
//                }
//            });
//        }
//
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        syncTest.notified();
        long timestamp = System.currentTimeMillis();

        String signature = DigestUtils.shaHex("credit_cash_banco" + "1500886897582" + "d1abf842-769c-11e7-8a6a-00163e0002a7");
        String url = "http://ocr.test.zhonganonline.com/zalabs/ocr/v1/id_card";

        System.out.println(signature);
        String base64 = getBase64("/Users/peng2035/zhongan/base64.txt");
        String base642 = getBase64("/Users/peng2035/zhongan/base642.txt");
        System.out.println(base64.equals(base642));
        JSONObject json = new JSONObject();
        json.put("productId", "credit_cash_banco");
        json.put("channelId", "1369");
        json.put("transactionNo", "11123123213");
        json.put("timestamp", "1500886897582" + "");
        json.put("signature", signature);
        json.put("image", base64);

        String resp = null;
        try {
            long startTime = System.currentTimeMillis();
            resp = executePostBody(url.trim(), JSONObject.toJSONString(json));
            long endTime = System.currentTimeMillis();
            JSONObject respJson = JSONObject.parseObject(resp);
            respJson.get("side");
        } catch (Exception e) {
        }
        System.out.println(resp);
    }

    private static String getBase64(String path) throws IOException {
        String base64 = "";
        File file = new File(path);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = null;
        while ((line = br.readLine()) != null) {        //一次读取一行
            base64 += line;
        }
        br.close();
        return base64;
    }

    public static String executePostBody(String url, String jsonString) {
        try {
            HttpClient client = new HttpClient();
            client.getHttpConnectionManager().getParams().setConnectionTimeout(60000);
            client.getHttpConnectionManager().getParams().setSoTimeout(60000);
            PostMethod post = new PostMethod(url);
            post.addRequestHeader("Content-Type", "application/json");
            post.setRequestHeader("Connection", "close");
            byte[] bytes = jsonString.getBytes("UTF-8");
            RequestEntity params = new ByteArrayRequestEntity(bytes);
            post.setRequestEntity(params);
            client.executeMethod(post);
            return streamReadHtml(post.getResponseBodyAsStream());
        } catch (Exception e) {
            System.out.println(e);
        }
        return "";
    }

    private static String streamReadHtml(InputStream istream) throws UnsupportedEncodingException {
        String html = "";
        byte[] responseBody = new byte[READ_BODY_SIZE];
        int npos = 0;
        int nread = 0;
        try {
            while ((nread = istream.read(responseBody, npos, responseBody.length - npos)) >= 0) {
                npos += nread;
                byte[] tmpBuf = new byte[npos + READ_BODY_SIZE];
                System.arraycopy(responseBody, 0, tmpBuf, 0, npos);
                responseBody = tmpBuf;
            }
        } catch (IOException e) {
        } finally {
            try {
                if (null != istream) {
                    istream.close();
                }
                istream = null;
            } catch (Exception e) {
            }
        }
        html = new String(responseBody, 0, npos, "UTF-8");
        return html;
    }

}
