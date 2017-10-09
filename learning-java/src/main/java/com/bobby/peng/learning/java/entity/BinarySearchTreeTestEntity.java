package com.bobby.peng.learning.java.entity;

import com.bobby.peng.learning.java.structure.BinarySearchTree;

/**
 *
 *
 * @author <a href="mailto:peng2035@163.com">彭天浩</a>
 * @version 1.0
 */
public class BinarySearchTreeTestEntity implements Comparable<BinarySearchTreeTestEntity>{

    private int value;

    public BinarySearchTreeTestEntity(int value) {
        this.value = value;
    }

    public int compareTo(BinarySearchTreeTestEntity o) {
        if(this.value == o.value) {
            return 0;
        } else if(this.value < o.value) {
            return -1;
        } else {
            return 1;
        }
    }

    @Override
    public String toString() {
        return value + "";
    }

    public static void main(String[] args) {
        BinarySearchTreeTestEntity[] binarySearchTreeTestEntities = new BinarySearchTreeTestEntity[30];

        BinarySearchTree<BinarySearchTreeTestEntity> binarySearchTreeTestEntityBinarySearchTree = new BinarySearchTree<BinarySearchTreeTestEntity>(binarySearchTreeTestEntities);
        binarySearchTreeTestEntityBinarySearchTree.binaryTest();
    }
}
