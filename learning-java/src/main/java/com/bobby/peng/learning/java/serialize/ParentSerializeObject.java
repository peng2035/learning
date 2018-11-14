package com.bobby.peng.learning.java.serialize;

import java.io.Serializable;

/**
 * Created by bobby.peng on 2018/11/14.
 */
public class ParentSerializeObject implements Serializable {

    private String parentValue;

    public ParentSerializeObject(String parentValue) {
        this.parentValue = parentValue;
    }
}