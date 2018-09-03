package com.learning.factory;

import java.util.concurrent.ThreadFactory;

/**
 * @Description 重写线程工厂类生成线程的方法
 * @ClassName TestThreadFactory
 * @Author Liumh
 * @Date 2018/9/3 14:55
 * @Version v1.0
 */
public class TestThreadFactory implements ThreadFactory {

    private Integer threadCount = 0;

    @Override
    public Thread newThread(Runnable r) {
        StringBuffer threadName = new StringBuffer();
        threadName.append("线程工厂").append(threadCount++);
        Thread thread = new Thread(r, threadName.toString());
        return thread;
    }

}
