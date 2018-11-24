package com.example;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @Description
 * @ClassName RedisConfig
 * @Author Liumh
 * @Date 2018/11/13 19:22
 * @Version v1.0
 */
@Configuration
public class RedisConfig extends CachingConfigurerSupport {

    @Bean
    public CacheManager cacheManager(RedisTemplate<?, ?> redisTemplate) {
        CacheManager cacheManager = new RedisCacheManager(redisTemplate);
        return cacheManager;
    }

    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory connectionFactory){
        RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(connectionFactory);
        return redisTemplate;
    }
}
