package com.hjpz.utils;
 
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
 
import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * Redis工具类
 */
@Component
@Slf4j
public class RedisUtil {
 
    @Resource
    private RedisTemplate<String, String> redisTemplate;
 
    public void set(String key, String value, long time) {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        valueOperations.set(key, value, time, TimeUnit.SECONDS);
    }
 
    public String get(String key) {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        return valueOperations.get(key);
    }

    /**
     * 指定缓存失效时间
     * @param key 键
     * @param time 时间(秒)
     * @return
     */
    public boolean expire(String key,long time){
        try {
            if(time>0){
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            log.error("指定缓存失效时间异常",e);
            return false;
        }
    }
}