package com.bobby.peng.learning.java.constants;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by bobby.peng on 2016/11/25.
 */
public class GlobalConstants {

    public static final Map<String,Class[]> METHOD_PARAM_TYPE_MAP = new ConcurrentHashMap<>();

    public static final Map<String,Class[]> CONSTRUCT_PARAM_TYPE_MAP = new ConcurrentHashMap<>();

}
