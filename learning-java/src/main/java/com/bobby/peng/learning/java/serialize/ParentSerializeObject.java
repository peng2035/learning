package com.bobby.peng.learning.java.serialize;

import java.io.Serializable;

/**
 * Created by bobby.peng on 2018/11/14.
 */
public class ParentSerializeObject {

    private String parentValue;

    public ParentSerializeObject() {
        this.parentValue = "234";
        System.out.println("ParentSerializeObject::Default:Constructor");
    }

    public ParentSerializeObject(String parentValue) {
        this.parentValue = parentValue;
    }

    public String getParentValue() {
        return parentValue;
    }
}