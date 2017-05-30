package com.bobby.peng.learning.basic.utils;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;

import java.util.List;
import java.util.UUID;

/**
 * Created by peng2035 on 16-11-29.
 */
public class RedisLockUtils<K> {

    private RedisUtils<K, String> redisUtils;

    public String acquireLock(K key, long lockTimeout, long acquireTimeout) {
        long endTime = System.currentTimeMillis() + acquireTimeout;
        String uuid = UUID.randomUUID().toString();
        while (System.currentTimeMillis() < endTime) {

            if (redisUtils.setNX(key, uuid)) {
                redisUtils.expire(key, lockTimeout);
                return uuid;
            }

            if (redisUtils.ttl(key) == 1) {
                redisUtils.expire(key, lockTimeout);
            }
        }

        return null;

    }

    public boolean unlock(K key, String uuid) {

        if(uuid == null) {
            return false;
        }

        while (true) {
            redisUtils.watch(key);
            String value = redisUtils.get(key);
            if (value != null && value.equals(uuid)) {

                if (!exec(key)) {
                    continue;
                }

                System.out.println(Thread.currentThread() + " unlock");
                return true;
            }

            redisUtils.unWatch(key);
            break;
        }

        return false;

    }

    private boolean exec(K key) {

        RedisTemplate<K,String> redisTemplate = redisUtils.getRedisTemplate();

        List<Object> results = redisTemplate.execute(new SessionCallback<List<Object>>() {
            public List<Object> execute(RedisOperations operations) throws DataAccessException {
                operations.multi();
                operations.delete(key);
                // This will contain the results of all ops in the transaction
                return operations.exec();
            }
        });

        return results != null;
    }

    public RedisUtils<K, String> getRedisUtils() {
        return redisUtils;
    }

    public void setRedisUtils(RedisUtils<K, String> redisUtils) {
        this.redisUtils = redisUtils;
    }
}
