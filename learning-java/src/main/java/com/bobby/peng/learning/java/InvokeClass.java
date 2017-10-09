package com.bobby.peng.learning.java;

import java.io.*;

/**
 * Created by peng2035 on 2017/5/29.
 */
public class InvokeClass extends SuperClass implements Serializable {

    private static final long serialVersionUID = 4287503716258182496L;

    private int value;

    public InvokeClass(int superValue, int value) {
        super(superValue);
        this.value = value;
    }

    @Override
    public String toString() {
        return super.toString() + ",value : " + value;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        InvokeClass invokeClass = new InvokeClass(5,10);

        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("InvokeClass.out"));
        outputStream.writeObject(invokeClass);

        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("InvokeClass.out"));
        InvokeClass invokeClass1 = (InvokeClass)inputStream.readObject();
        System.out.println(invokeClass1);
    }

}
