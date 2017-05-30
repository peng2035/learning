package com.bobby.peng.learning;

import java.io.Serializable;

/**
 * Created by peng2035 on 2017/5/29.
 */
public class SuperClass implements Serializable {

    private static final long serialVersionUID = 2572803392607813184L;

    private int superValue;

    public SuperClass() {
    }

    public SuperClass(int superValue) {
        this.superValue = superValue;
    }

    @Override
    public String toString() {
        return "super : " + superValue;
    }
}
