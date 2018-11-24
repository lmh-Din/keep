package com.example;

/**
 * @Description
 * @ClassName RedisService
 * @Author Liumh
 * @Date 2018/11/13 20:26
 * @Version v1.0
 */
public interface RedisService {

    void setStr(String key, String value);

    String getStr(String key);
}
