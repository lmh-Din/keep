package com.example.spring;

import com.example.config.annotation.AopLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @Description 异步方法测试类
 * @ClassName AnnatationAsync
 * @Author Liumh
 * @Date 2018/11/1 14:56
 * @Version v1.0
 */
@Component
//@Async
@Slf4j
public class AnnatationAsync {

    @AopLog
    public void noResultTest(){
        log.info("noResultTest method process starting。。。。。");

    }

    @AopLog
    public void noResultTest(String a, int i, long l) {
        log.info("String:{},int:{},long:{}", a, i, l);
    }

    @AopLog
    public void noResultTest(List<String> strs, List<Map<String, Object>> maps, Map<Object, Object> map){

    }
}
