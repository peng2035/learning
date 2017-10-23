package com.bobby.peng.learning.java.basic.utils;

import java.lang.reflect.Field;

/**
 *
 *
 * @author <a href="mailto:peng2035@163.com">彭天浩</a>
 * @version 1.0
 */
public class StringUtils extends org.apache.commons.lang.StringUtils {

    public static String[] buildStringToArray(String str) {

        str = str.replace("\"", "");
        str = str.replace("'", "");
        str = str.replace(" ", "");

        String[] result = str.split(",");

        return result;
    }

    public static int[] buildStringToIntArray(String str) {

        String[] array = buildStringToArray(str);
        int[] result = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            result[i] = Integer.parseInt(array[i]);
        }

        return result;
    }

    public static String fieldToString(Object object) {
        Class tClass = object.getClass();

        StringBuilder sb = new StringBuilder();
        try {
            while (tClass != null) {
                Field[] fields = tClass.getDeclaredFields();

                for (Field field : fields) {
                    field.setAccessible(true);
                    sb.append(" , \"").append(field.getName()).append("\" : \"").append(field.get(object)).append("\"");
                }

                tClass = tClass.getSuperclass();
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        if (sb.length() > 0) {
            return sb.substring(2, sb.length());
        }

        return sb.toString();
    }

}
