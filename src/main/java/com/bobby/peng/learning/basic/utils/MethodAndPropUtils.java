package com.bobby.peng.learning.basic.utils;

import com.bobby.peng.learning.constants.GlobalConstants;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bobby.peng on 2016/11/25.
 */
public class MethodAndPropUtils {

    public static void parseMethodAndPropUtils(Class clazz, String[] methodAndProp) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        String[] methodNames = buildMethods(methodAndProp[0]);
        List<Integer>[] props = buildProps(methodAndProp[1], methodNames.length);

        Object[] result = new Object[methodNames.length];
        if (methodNames.length != props.length) throw new RuntimeException("input error");

        Constructor c = clazz.getConstructor(GlobalConstants.CONSTRUCT_PARAM_TYPE_MAP.get(clazz.getName() + "." + methodNames[0]));
        Object object = c.newInstance(props[0].toArray());

        for (int i = 1; i < methodNames.length; i++) {
            Method method = clazz.getMethod(methodNames[i], GlobalConstants.METHOD_PARAM_TYPE_MAP.get(clazz.getName() + "." + methodNames[i]));

            if ("".equals(props[i])) {
                result[i] = method.invoke(object);
            } else {
                result[i] = method.invoke(object, props[i].toArray());
            }
            System.out.println("method:" + method.getName() + "  prop:" + props[i].toString() + "  result:" + result[i]);
        }
    }

    private static String[] buildMethods(String method) {
        method = removeUnnecessaryChars(method);
        return method.split(",");
    }

    private static List<Integer>[] buildProps(String prop, int size) {
        List<Integer>[] props = new List[size];
        int index = 0;
        for (int i = 1; i < prop.length() - 1; i++) {
            if (prop.charAt(i) == '[') {
                int start = i;
                while (prop.charAt(i) != ']') {
                    i++;
                }
                String temp = prop.substring(start + 1, i);
                List<Integer> value = new ArrayList<>();
                for (String each : temp.split(",")) {
                    value.add(Integer.parseInt(each));
                }

                props[index++] = value;
            }
        }
        return props;
    }

    private static String removeUnnecessaryChars(String str) {
        str = str.replaceAll("\"", "");
        str = str.replace("[", "");
        str = str.replace("]", "");

        return str;
    }
}
