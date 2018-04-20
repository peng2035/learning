package com.bobby.peng.learning.java.basic.data.structure;

/**
 * Created by bobby.peng on 2018/4/20.
 */
public class ConstantHashCodeObj {

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        return obj == this;
    }

}
