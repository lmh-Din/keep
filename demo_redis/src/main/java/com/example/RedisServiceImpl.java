package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @ClassName RedisServiceImpl
 * @Author Liumh
 * @Date 2018/11/13 20:26
 * @Version v1.0
 */
@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void setStr(String key, String value) {
        StringRedisSerializer redisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(redisSerializer);
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set(key, value);
    }

    @Override
    public String getStr(String key) {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        return (String) valueOperations.get(key);
    }
}
