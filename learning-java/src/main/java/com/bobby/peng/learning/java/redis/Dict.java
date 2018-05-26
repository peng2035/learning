package com.bobby.peng.learning.java.redis;

/**
 * Created by bobby.peng on 15/01/2018.
 */
public class Dict<K, V> {

    DictNode<K, V>[] table;
    DictNode<K, V>[] table2;

    int size;

    public Dict() {
        this.size = 16;
    }

    public void reHash() {

    }

    static class DictNode<K, V> {
        K key;
        V value;
        Dict<K, V> next;
    }

}
