package com.bobby.peng.learning.data.structure;

import java.util.Random;

/**
 *
 *
 * @author <a href="mailto:peng2035@163.com">彭天浩</a>
 * @version 1.0
 */
public class SkipList<T extends Comparable<? super T>> {

    private static final double P = 0.5d;

    private static final int MAX_LEVEL = 32;

    private class SkipListNode<T extends Comparable<? super T>> {
        private SkipListNode<T> up, down, left, right;

        private T value;

        public SkipListNode(T value) {
            this.value = value;

            up = down = right = left = null;
        }

        public SkipListNode(SkipListNode<T> up, SkipListNode<T> down, SkipListNode<T> left, SkipListNode<T> right, T value) {
            this.up = up;
            this.down = down;
            this.left = left;
            this.right = right;
            this.value = value;
        }

        public SkipListNode<T> getUp() {
            return up;
        }

        public void setUp(SkipListNode<T> up) {
            this.up = up;
        }

        public SkipListNode<T> getDown() {
            return down;
        }

        public void setDown(SkipListNode<T> down) {
            this.down = down;
        }

        public SkipListNode<T> getRight() {
            return right;
        }

        public void setRight(SkipListNode<T> right) {
            this.right = right;
        }

        public SkipListNode<T> getLeft() {
            return left;
        }

        public void setLeft(SkipListNode<T> left) {
            this.left = left;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }
    }

    public SkipList() {
        head = new SkipListNode<>(null);
        tail = new SkipListNode<>(null);

        head.right = tail;
        tail.left = head;

        currentMaxLevel = 0;
    }

    private SkipListNode<T> head;

    private SkipListNode<T> tail;

    private int currentMaxLevel;

    public void insert(T value) {
        if (value == null) {
            throw new RuntimeException();
        }

        int level = 3;
        if (level >= currentMaxLevel) {
            extendHeadAndTailNode(level);
            currentMaxLevel = level + 1;
        }

        SkipListNode tempNode = head.down;
        int tempLevel = currentMaxLevel - 1;
        //need to add node in this level?
        boolean flag = checkLevel(level, tempLevel);
        SkipListNode upNode = null;


        while (tempNode != null) {
            tempNode = tempNode.right;
            if (tempNode.value == null || tempNode.value.compareTo(value) > 0) {
                if (flag) {
                    SkipListNode addedNode = addNode(upNode, tempNode, value);
                    tempNode = addedNode.left.down;
                    upNode = addedNode;
                } else {
                    tempNode = tempNode.left.down;
                }
                tempLevel--;
            } else if (tempNode.value.compareTo(value) == 0) {
                insertNodeWhenEqual(upNode, tempNode);
                break;
            }
            flag = checkLevel(level, tempLevel);
        }

    }

    private boolean checkLevel(int level, int tempLevel) {
        return level >= tempLevel ? true : false;
    }

    public boolean delete(T value) {
        SkipListNode deleteNode = get(value);
        if (deleteNode == null) {
            return false;
        } else {
            while (deleteNode != null) {
                deleteNode.left.right = deleteNode.right;
                deleteNode.right.left = deleteNode.left;
                deleteNode = deleteNode.down;
            }

            while (head.down.right.value == null) {
                head.down.up = null;
                head = head.down;

                tail.down.up = null;
                tail = tail.down;
            }

            return true;
        }
    }

    public boolean existed(T value) {
        return get(value) == null ? false : true;
    }

    private SkipListNode get(T value) {

        if (value == null) {
            throw new RuntimeException("get null error");
        }

        SkipListNode tempNode = head.down;

        while (tempNode != null) {
            tempNode = tempNode.right;
            if (tempNode.value == null || tempNode.value.compareTo(value) > 0) {
                tempNode = tempNode.left.down;
            } else if (tempNode.value.compareTo(value) == 0) {
                return tempNode;
            }
        }

        return null;

    }

    private void insertNodeWhenEqual(SkipListNode upNode, SkipListNode currentNode) {
        SkipListNode<T> addedNode = new SkipListNode(upNode, null, currentNode.left, currentNode, currentNode.value);

        if (upNode != null) upNode.down = addedNode;
        currentNode.left.right = addedNode;
        currentNode.left = addedNode;

        if (currentNode.down != null) insertNodeWhenEqual(addedNode, currentNode.down);
    }

    private int getRandomLevel() {
        int level = 0;

        Random random = new Random();
        random.setSeed(System.currentTimeMillis());

        while (((double) random.nextInt(100)) / 100 < P && level < MAX_LEVEL) {
            level++;
        }

        return level;
    }

    private void extendHeadAndTailNode(int randomLevel) {
        for (int i = currentMaxLevel - 1; i < randomLevel; i++) {
            SkipListNode addedHead = new SkipListNode(null);
            SkipListNode addedTailNode = new SkipListNode(null);
            addedHead.down = head;
            addedHead.right = addedTailNode;
            addedTailNode.down = tail;
            addedTailNode.left = addedHead;

            head.up = addedHead;
            head = addedHead;
            tail.up = addedTailNode;
            tail = addedTailNode;
        }
    }

    private SkipListNode addNode(SkipListNode upNode, SkipListNode tempNode, T value) {
        SkipListNode addedNode = new SkipListNode(null, null, tempNode.left, tempNode, value);
        if (upNode != null) {
            addedNode.up = upNode;
            upNode.down = addedNode;
        }
        tempNode.left.right = addedNode;
        tempNode.left = addedNode;
        return addedNode;
    }


    private void printResult() {
        SkipListNode node = head;
        while (node.down != null) {
            node = node.down;
        }

        while (node.right != null) {
            System.out.print(node.value + "->");
            node = node.right;
        }
    }

    public static void main(String[] args) {
        SkipList<Integer> skipList = new SkipList<>();

        Random random = new Random();

        int temp = 0;

        int temp2 = 3;
        for (int i = 0; i < 10; i++) {
            int intValue = random.nextInt(5);
            System.out.print(intValue + ",");
            skipList.insert(intValue);
        }

        System.out.println();
        skipList.printResult();

        skipList.delete(temp);
        skipList.delete(temp2);

        System.out.println();
        skipList.printResult();
    }
}
