package com.bobby.peng.learning.java.structure;


/**
 *
 *
 * @author <a href="mailto:peng2035@163.com">彭天浩</a>
 * @version 1.0
 */
public class BinarySearchTree<T extends Comparable<T>> {

    private BinaryNode<T> head = null;

    public BinarySearchTree() {

    }

    public BinarySearchTree(T[] ts) {
        for(T t : ts) {
            insert(t);
        }
    }

    private class BinaryNode<T> {
        BinaryNode<T> leftChild;

        BinaryNode<T> rightChild;

        T value;

        public BinaryNode(T value) {
            this.value = value;
        }

        public BinaryNode(T value, BinaryNode<T> leftChild, BinaryNode<T> rightChild) {
            this.value = value;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }
    }

    public void insert(T t) {
        if (head == null) {
            head = new BinaryNode<T>(t);
            return;
        }

        insert(head, t);
    }

    public void insert(BinaryNode<T> node, T t) {
        if (node.value.compareTo(t) == 0) {
            return;
        } else if (node.value.compareTo(t) == -1) {
            if (node.leftChild == null) {
                BinaryNode<T> binaryNode = new BinaryNode<T>(t);
                node.leftChild = binaryNode;
            } else {
                insert(node.leftChild, t);
            }
        } else {
            if (node.rightChild == null) {
                BinaryNode<T> binaryNode = new BinaryNode<T>(t);
                node.rightChild = binaryNode;
            } else {
                insert(node.rightChild, t);
            }
        }
    }

    public boolean contains(T t) {
        return contains(head, t);
    }

    private boolean contains(BinaryNode<T> node, T t) {
        if (node == null) {
            return false;
        }

        while (node.value.compareTo(t) != 0) {
            if (node.value.compareTo(t) == -1) {
                node = node.leftChild;
            } else {
                node = node.rightChild;
            }
            return contains(node, t);
        }

        return true;
    }

    public T findMin() {
        if (head == null) {
            return null;
        }
        BinaryNode<T> binaryNode = head;
        while (binaryNode.leftChild != null) {
            binaryNode = binaryNode.leftChild;
        }
        return binaryNode.value;
    }

    public T findMax() {
        if (head == null) {
            return null;
        }
        BinaryNode<T> binaryNode = head;
        while (binaryNode.rightChild != null) {
            binaryNode = binaryNode.rightChild;
        }
        return binaryNode.value;
    }

    @Override
    public String toString() {
        if(head != null) {
            toString(head,1);
        }
        return "";
    }

    public void toString(BinaryNode<T> binaryNode, int i) {
        for(int j=0;j<i;j++) {
            System.out.print("---  ");
        }
        System.out.println(binaryNode.value);
        if(binaryNode.leftChild != null) {
            toString(binaryNode.leftChild, ++i);
        }
        if (binaryNode.rightChild != null) {
            toString(binaryNode.rightChild, ++i);
        }
    }

    private BinaryNode<T> findMin(BinaryNode<T> node) {

        while (node.leftChild != null) {
            node = node.leftChild;
        }
        return node;
    }

    private boolean remove(T t) {
        return remove(head,t) != null;
    }

    private BinaryNode<T> remove(BinaryNode<T> binaryNode, T t) {
        if(binaryNode == null) {
            return null;
        }

        if(binaryNode.value.compareTo(t) == -1) {
            binaryNode.leftChild = remove(binaryNode.leftChild,t);
        } else if(binaryNode.value.compareTo(t) == 1) {
            binaryNode.rightChild = remove(binaryNode.rightChild,t);
        } else {
            if(binaryNode.leftChild != null && binaryNode.rightChild != null) {
                binaryNode.value = findMin(binaryNode.rightChild).value;
                return remove(binaryNode.rightChild,binaryNode.value);
            } else {
                binaryNode = (binaryNode.leftChild == null ? binaryNode.rightChild : binaryNode.leftChild);
                return binaryNode;
            }
        }

        return binaryNode;
    }

    public void binaryTest() {
        System.out.println("leftChild : " + head.leftChild.leftChild.value);
        System.out.println("rightChild : " + head.rightChild.rightChild.value);

        BinaryNode binaryNode = head.leftChild.leftChild;
        binaryNode.leftChild = head.rightChild.rightChild;

        System.out.println("leftChild : " + head.leftChild.leftChild.leftChild.value);
    }

    public static void main(String[] args) {

    }
}
