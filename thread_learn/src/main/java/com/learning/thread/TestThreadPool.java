package com.learning.thread;

import com.learning.entity.Person;
import com.learning.factory.TestThreadFactory;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @Description 线程池测试
 * @ClassName TestThreadPool
 * @Author Liumh
 * @Date 2018/9/3 14:41
 * @Version v1.0
 */
@Slf4j
public class TestThreadPool {

    public static void main(String[] args){
        ThreadFactory threadFactory = new TestThreadFactory();
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(3, 3,
                1, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(10, false),
                threadFactory);
        threadPool.allowCoreThreadTimeOut(true);
        Person person = new Person();
        threadPool.submit(new TestRunable(person));
        threadPool.submit(new TestRunable(person));
        threadPool.submit(new TestRunable(person));
        threadPool.submit(new TestRunable(person));

        log.info("线程池存活线程数：{}", threadPool.getActiveCount());
        log.info("线程池工厂：{}", threadPool.getThreadFactory());
        while (true){
            if (threadPool.getActiveCount() > 0){
                log.info("线程池存活线程数：{}", threadPool.getActiveCount());
            }else {
                return;
            }
        }
    }
}
