package com.bobby.peng.learning.utils;

import com.bobby.peng.learning.AbstractTestCase;
import com.bobby.peng.learning.redis.RecentContract;
import org.junit.Ignore;
import org.springframework.stereotype.Component;

/**
 * Created by peng2035 on 16-12-3.
 */
@Component
public class ContractTest extends AbstractTestCase {

//    @Autowired
    private RecentContract recentContract;

    @org.junit.Test
    @Ignore
    public void test() {
        for (int i = 0; i < 3; i++) {
            recentContract.insertNewContract("aaaa" + i);
        }

        System.out.println(recentContract.getContracts("aa"));

        for (int i = 0; i < 5; i++) {
            recentContract.insertNewContract("bb" + i);
        }
        System.out.println(recentContract.getContracts("b"));
        System.out.println(recentContract.getContracts("b3"));

    }

}
