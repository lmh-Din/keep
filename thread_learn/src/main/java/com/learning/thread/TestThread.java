package com.learning.thread;

import com.learning.entity.Person;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description TODO
 * @ClassName TestThread
 * @Author Liumh
 * @Date 2018/8/29 10:59
 * @Version v1.0
 */
@Slf4j
public class TestThread extends Thread {

    private Integer sleepTime = 1000;   //毫秒

    private String threadName = "mainThread";  //线程名称

    private Person person = null;

    public TestThread(Person person) {
        this.person = person;
    }

    public TestThread() {
    }

    @Override
    public void run() {
        try {
            log.info("线程：{}将sleep：{}毫秒", threadName, sleepTime);
            Thread.sleep(sleepTime);
        }catch (Exception e){
            log.error("线程sleep异常", e);
        }
        synchronized (person){
            log.info("线程：{}将进入等待状态", threadName);
            try {
                person.wait();
                log.info("线程被唤醒");
            } catch (InterruptedException e) {
                log.error("线程等待异常", e);
            }
        }
    }
}
