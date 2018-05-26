package com.bobby.peng.learning.java.zookeeper;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;

/**
 * Created by bobby.peng on 2017/9/20.
 */
public class ZKClientTest {

    public static void main(String[] args) throws InterruptedException {
        String zookeeperServer = "106.14.115.150:2181";
        int connectionTimeout = 3000;
        ZkClient zkClient = new ZkClient(zookeeperServer,connectionTimeout);

        String path = "/learning-zk";

        if(zkClient.exists(path)) {
            zkClient.delete(path);
        }

        zkClient.createPersistent(path);

        zkClient.writeData(path,"learning-zk-data");

        String data = zkClient.<String>readData(path);
        System.out.println("read data from path : " + path + ", data : " + data);

        zkClient.subscribeDataChanges(path, new IZkDataListener() {
            @Override
            public void handleDataChange(String s, Object o) throws Exception {
                System.out.println("get data change from path : " + path + ", changed data : " + s);
            }

            @Override
            public void handleDataDeleted(String s) throws Exception {
                System.out.println("get data delete from path : " + path + ", deleted data : " + s);
            }
        });

        zkClient.writeData(path,"learning-zk-data-changed");
//        Thread.sleep(10000);
        zkClient.delete(path);

        Thread.sleep(10000);
    }

}
