package com.bobby.peng.learning.java.jdk;

/**
 *
 *
 * @author <a href="mailto:peng2035@163.com">彭天浩</a>
 * @version 1.0
 */
public class HashMapTest {

    public int testHash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    public static void main(String[] args) {
        HashMapTest hashMapTest = new HashMapTest();

        hashMapTest.testHash(1);
    }

}
