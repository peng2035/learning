package com.bobby.peng.learning.java.learning.utils;

import com.bobby.peng.learning.java.learning.AbstractTestCase;
import com.bobby.peng.learning.java.basic.utils.RedisUtils;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * @author <a href="mailto:peng2035@163.com">彭天浩</a>
 * @version 1.0
 */
@Component
public class RedisUtilsTest extends AbstractTestCase {

    @Autowired
    private RedisUtils<String, String> redisUtils;

    @Test
    public void test() {
        for (int i = 0; i < 1000; i++) {
            redisUtils.set("scan:await:key:" + i, "value");
        }
    }

    @Test
    public void testScan() {
        redisUtils.scan("scan*",100);
    }

}
