package com.bobby.peng.learning.java.learning.utils;

import com.bobby.peng.learning.java.learning.AbstractTestCase;
import com.bobby.peng.learning.java.basic.utils.RedisUtils;
import org.junit.Ignore;
import org.junit.Test;
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

//    @Autowired
//    @Qualifier("redisUtilsTest")
    private RedisUtils<String,List<Integer>> redisUtils;

    @Test
    @Ignore
    public void test() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(3);
        redisUtils.set("list", list);
        System.out.println(redisUtils.get("list"));
    }

}
