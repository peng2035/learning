package com.bobby.peng.learning.java.serialize;

import java.io.*;

/**
 * Created by bobby.peng on 2018/11/13.
 */
public class SerializeObject extends ParentSerializeObject implements Serializable {

    private String value;

    private String value2;

//    public SerializeObject() {
//        System.out.println("in no param constructor");
//    }

    public SerializeObject(String value, String value2) {
        super("123");
        this.value = value;
        this.value2 = value2;

        System.out.println("in all params constructor");

    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SerializeObject serializeObject = new SerializeObject("1", "2");
        FileOutputStream fos = new FileOutputStream("SerializeObject.out");

        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(serializeObject);

        oos.close();


        FileInputStream fis = new FileInputStream("SerializeObject.out");

        ObjectInputStream ois = new ObjectInputStream(fis);

        serializeObject = (SerializeObject) ois.readObject();

        System.out.println(serializeObject.value + "," + serializeObject.value2 + "," + serializeObject.getParentValue());
        ois.close();

    }
}
