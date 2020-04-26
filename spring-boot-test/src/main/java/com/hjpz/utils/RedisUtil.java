package com.hjpz.utils;
 
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
 
import javax.annotation.Resource;

/**
 * Redis工具类
 */
@Component
public class RedisUtil {
 
    @Resource
    private RedisTemplate<String, String> redisTemplate;
 
    public void set(String key, String value) {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        valueOperations.set(key, value);
    }
 
    public String get(String key) {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        return valueOperations.get(key);
    }
 
}