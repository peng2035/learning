package com.bobby.peng.learning.java.basic.test;

/**
 * Created by bobby.peng on 2016/10/8.
 */
public class TryWithResources {

    class Connection implements AutoCloseable {

        public void sendData() {
            System.out.println("正在发送数据");
        }

        @Override
        public void close() throws Exception {
            System.out.println("正在关闭连接");
        }
    }

    public static void main(String[] args) {


        TryWithResources tryWithResources = new TryWithResources();
        try(Connection connection = tryWithResources.new Connection()) {

            connection.sendData();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
