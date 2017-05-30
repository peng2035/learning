package com.bobby.peng.learning.basic.utils;

/**
 *
 *
 * @author <a href="mailto:peng2035@163.com">彭天浩</a>
 * @version 1.0
 */
public class StringUtils extends org.apache.commons.lang.StringUtils{

    public static String[] buildStringToArray(String str) {

        str = str.replace("\"","");
        str = str.replace("'","");
        str = str.replace(" ","");

        String[] result = str.split(",");

        return result;
    }

}
