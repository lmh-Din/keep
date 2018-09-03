package com.learning;

import com.learning.entity.Person;
import com.learning.thread.TestRunable;
import com.learning.thread.TestThread;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description TODO
 * @ClassName ThreadWait
 * @Author Liumh
 * @Date 2018/8/29 17:30
 * @Version v1.0
 */
@Slf4j
public class ThreadWait {

    public static void main(String[] args){
        Person person = new Person();
        TestThread thread = new TestThread(person);
        TestRunable runable = new TestRunable(person);
        Thread runableThread = new Thread(runable);
        log.info("mainThread线程执行");
        thread.start();
        try {
            Thread.sleep(10000);
            log.info("线程已经睡眠：{}", "10000");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("mainRunnable线程执行");
        runableThread.start();
    }
}
