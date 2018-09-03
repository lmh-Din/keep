package com.learning.thread;

import com.learning.entity.Person;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description TODO
 * @ClassName TestRunable
 * @Author Liumh
 * @Date 2018/8/29 11:01
 * @Version v1.0
 */
@Slf4j
public class TestRunable implements Runnable {

    private Integer sleepTime = 1000;   //毫秒

    private String threadName = "mainRunnable";  //线程名称

    private Person person = null;

    public TestRunable(Person person) {
        this.person = person;
    }

    @Override
    public void run() {
        try {
            log.info("线程：{}执行", Thread.currentThread().getName());
        }catch (Exception e){
            log.error("线程异常", e);
        }
    }
}
