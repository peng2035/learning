package com.bobby.peng.learning.java.basic.data.structure;

/**
 *
 *
 * @author <a href="mailto:peng2035@163.com">彭天浩</a>
 * @version 1.0
 */
public class LinkedNode {

    public int value;

    public LinkedNode next;

    public LinkedNode() {
    }

    public LinkedNode(int value) {
        this.value = value;
    }

    public LinkedNode(LinkedNode next) {
        this.next = next;
    }

    public LinkedNode(int value, LinkedNode next) {
        this.value = value;
        this.next = next;
    }
}
