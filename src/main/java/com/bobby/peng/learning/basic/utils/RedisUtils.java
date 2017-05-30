package com.bobby.peng.learning.basic.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.util.Assert;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 *
 *
 * @author <a href="mailto:peng2035@163.com">彭天浩</a>
 * @version 1.0
 */
public class RedisUtils<K, V> implements InitializingBean {

    private RedisTemplate<K, V> redisTemplate;

    private RedisSerializer redisSerializer;

    private final static int DEFAULT_ZSET_START = 0;

    private final static int DEFAULT_ZSET_END = -1;

    private final static double DEFAULT_ZSET_INCR_DELTA = 1;

    RedisUtils() {
        System.out.println("instance start");

        if (getRedisTemplate() == null) {
            System.out.println("redis template is null");
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (redisTemplate == null) {
            redisTemplate = new RedisTemplate<K, V>();
        }
        if (redisSerializer == null) {
            redisSerializer = new StringRedisSerializer();
            redisTemplate.setKeySerializer(redisSerializer);
        }

    }

    public void watch(K key) {
        redisTemplate.watch(key);
    }

    public void watch(List<K> keys) {
        redisTemplate.watch(keys);
    }

    public void unWatch(K key) {
        redisTemplate.unwatch();
    }

    public void multi() {
        redisTemplate.multi();
    }

    public Long ttl(K key) {
        return redisTemplate.getExpire(key,TimeUnit.MILLISECONDS);
    }



    public boolean keys(K key) {
        return redisTemplate.hasKey(key);
    }

    public boolean expire(K key,long time) {
        return redisTemplate.expire(key,time, TimeUnit.MILLISECONDS);
    }

    public boolean expireAt(K key,long time) {
        return redisTemplate.expireAt(key,new Date(time));
    }

    public void del(K key) {
        redisTemplate.delete(key);
    }

    public List<Object> exec() {
        return redisTemplate.exec();
    }

    public V get(K key) {
        return redisTemplate.opsForValue().get(key);
    }

    public void set(K key, V value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public boolean setNX(K key, V value) {
        return redisTemplate.opsForValue().setIfAbsent(key,value);
    }

    public boolean zadd(K key, V value, double score) {
        return redisTemplate.opsForZSet().add(key, value, score);
    }

    public double zIncr(K key, V value, double delta) {
        return redisTemplate.opsForZSet().incrementScore(key, value, delta);
    }

    public List<ZSetOperations.TypedTuple<V>> zIncrValues(K key, V[] values) {
        List<ZSetOperations.TypedTuple<V>> valueScores = new ArrayList<>();

        for (V value : values) {
            valueScores.add(new DefaultTypedTuple<V>(value, DEFAULT_ZSET_INCR_DELTA));
        }

        return zIncrValues(key, valueScores);
    }

    public List<ZSetOperations.TypedTuple<V>> zIncrValues(K key, List<ZSetOperations.TypedTuple<V>> values) {
        List<Object> scores = redisTemplate.execute(new RedisCallback<List<Object>>() {
            @Override
            public List<Object> doInRedis(RedisConnection connection) throws DataAccessException {
                connection.openPipeline();

                for (ZSetOperations.TypedTuple value : values) {
                    connection.zIncrBy(rawKey(key), value.getScore(), rawValue(value.getValue()));
                }

                return connection.closePipeline();
            }
        });

        List<ZSetOperations.TypedTuple<V>> result = new ArrayList<>(scores.size());

        int index = 0;
        for (ZSetOperations.TypedTuple<V> value : values) {
            result.add(new DefaultTypedTuple<V>(value.getValue(), (Double) scores.get(index++)));
        }

        return result;
    }

    public Long zCard(K key) {
        return redisTemplate.opsForZSet().zCard(key);
    }

    public Set<V> zGetAll(K key) {
        return zRange(key, DEFAULT_ZSET_START, DEFAULT_ZSET_END);
    }

    public Set<V> zReserveGetAll(K key) {
            return zReverseRange(key, DEFAULT_ZSET_START, DEFAULT_ZSET_END);
        }

    public Set<V> zRangeWithStart(K key, long start) {
        return zRange(key, start, DEFAULT_ZSET_END);
    }

    public Set<V> zRangeWithEnd(K key, long end) {
        return zRange(key, DEFAULT_ZSET_START, end);
    }

    public Set<V> zRange(K key, long start, long end) {
        return redisTemplate.opsForZSet().range(key, start, end);
    }

    public Set<V> zReverseRange(K key, long start, long end) {
        return redisTemplate.opsForZSet().reverseRange(key, start, end);
    }

    public Set<ZSetOperations.TypedTuple<V>> zRangeWithScore(K key) {
        return redisTemplate.opsForZSet().rangeWithScores(key, DEFAULT_ZSET_START, DEFAULT_ZSET_END);
    }

    public Set<ZSetOperations.TypedTuple<V>> zRangeWithScore(K key, long start) {
        return redisTemplate.opsForZSet().rangeWithScores(key, start, DEFAULT_ZSET_END);
    }

    public Set<ZSetOperations.TypedTuple<V>> zRangeWithScore(K key, long start, long end) {
        return redisTemplate.opsForZSet().rangeWithScores(key, start, end);
    }

    public Long zrank(K key,V member) {
        return redisTemplate.opsForZSet().rank(key,member);
    }

    public long zRem(K key, V... member) {
        return redisTemplate.opsForZSet().remove(key, member);
    }

    public RedisTemplate<K, V> getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate<K, V> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public RedisSerializer getRedisSerializer() {
        return redisSerializer;
    }

    public void setRedisSerializer(RedisSerializer redisSerializer) {
        this.redisSerializer = redisSerializer;
    }

    private RedisSerializer keySerializer() {
        return redisTemplate.getKeySerializer();
    }

    private RedisSerializer valueSerializer() {
        return redisTemplate.getValueSerializer();
    }

    byte[] rawKey(Object key) {
        Assert.notNull(key, "non null key required");
        if (keySerializer() == null && key instanceof byte[]) {
            return (byte[]) key;
        }
        return keySerializer().serialize(key);
    }

    byte[] rawValue(Object value) {
        if (valueSerializer() == null && value instanceof byte[]) {
            return (byte[]) value;
        }
        return valueSerializer().serialize(value);
    }

    byte[][] rawValues(Object... values) {
        final byte[][] rawValues = new byte[values.length][];
        int i = 0;
        for (Object value : values) {
            rawValues[i++] = rawValue(value);
        }
        return rawValues;
    }
}
