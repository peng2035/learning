package com.bobby.peng.learning.java.redis;

import com.bobby.peng.learning.java.basic.utils.RedisUtils;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by peng2035 on 16-12-3.
 */
//@Service
public class RecentContract {

    private static final Logger logger = Logger.getLogger(RecentContract.class);

//    @Autowired
//    @Qualifier("contractRedisUtils")
    private RedisUtils<String,String> redisUtils;

    private final static int CONTRACT_LIMITED = 5;

    private final static String KEY = "contract";

    public List<String> getContracts(String value) {
        Set<String> members = redisUtils.zReserveGetAll(KEY);

        List<String> result = new ArrayList<>();
        for(String member : members) {
            if(member.indexOf(value)!=-1) {
                result.add(member);
            }
        }

        redisUtils.zIncrValues(KEY, result.toArray(new String[result.size()]));

        return result;
    }

    public synchronized void insertNewContract(String value) {

        if(redisUtils.zrank(KEY,value) != null) {
            redisUtils.zIncr(KEY,value,1d);
            return;
        }

        Long count = redisUtils.zCard(KEY);

        if(count == CONTRACT_LIMITED) {
            String lastMember = redisUtils.zReverseRange(KEY,-1,-1).iterator().next();
            redisUtils.zRem(KEY,lastMember);
            logger.info("delete the last value: " + lastMember);
        }

        redisUtils.zadd(KEY,value,1);
    }

}
