package com.learning.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description 线程安全的Integer
 * @ClassName MyIntegerThread
 * @Author Liumh
 * @Date 2018/9/4 10:12
 * @Version v1.0
 */
@Slf4j
public class MyIntegerThread implements Runnable {

    public static AtomicInteger ai = new AtomicInteger(0);

    @Override
    public void run() {
        for (int m=0; m<1000; m++){
            log.info("{}获取自增数字前：{}", Thread.currentThread().getName(), ai);
            ai.getAndIncrement();
            log.info("{}获取自增数字后：{}", Thread.currentThread().getName(), ai);
        }
    }
}
