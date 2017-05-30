package com.bobby.peng.learning.exams;

/**
 * Created by peng2035 on 16-11-29.
 */
public class ClassT<T>{

    private Class<T> value;

    public Class<T> getValue() {
        return value;
    }

    public void setValue(Class<T> value) {
        this.value = value;
    }
}
