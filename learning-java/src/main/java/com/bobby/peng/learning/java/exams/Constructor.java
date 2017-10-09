package com.bobby.peng.learning.java.exams;


import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 *
 * @author <a href="mailto:peng2035@163.com">彭天浩</a>
 * @version 1.0
 */
public class Constructor {

    @Autowired
    ClassA classA;

    public Constructor constructor;

    private String field;

    public Constructor() {
        this.field = "hello";
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public static void main(String[] args) {
        Constructor constructor = new Constructor();

        if(constructor.constructor == null) {
            System.out.println("yes");
        }
    }
}
