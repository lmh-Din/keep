package com.learning.example;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 线程测试类
 * Created by Liumh on 2018/8/28.
 */
@Slf4j
public class ThreadTest {

    @Test
    public void testThreadMethod(){
        try {
            Thread thread1 = new Thread(new Thread1());
            thread1.start();

        }catch (Exception e){
            log.error("线程异常捕获测试", e);
        }
    }

    @Test
    public void testCallableThread(){
        Thread2 thread2 = new Thread2();
        try {
            FutureTask<String> futureTask = new FutureTask<String>(thread2);
            Thread startThread = new Thread(futureTask);
            Thread test2 = new Thread(futureTask);
            Thread test3 = new Thread(futureTask);
            Thread test4 = new Thread(futureTask);
            startThread.start();
            test2.start();
            futureTask.cancel(true);
//            log.info("线程返回值：{}", futureTask.get());
            test3.start();
            test4.start();
            Thread currentThread = Thread.currentThread();
            log.info("当前运行的线程：{}", currentThread.getName());
        }catch (Exception e){
            log.error("Exception", e);
        }

    }


    //实现Runnable接口
    class Thread1 implements Runnable {

        @Override
        public void run() {
            System.out.println("线程测试");
            log.info("线程测试：{}", "Runnable");
            throw new RuntimeException("Runnable线程异常测试");
        }
    }
    //实现Callable接口
    class Thread2 implements Callable<String> {

        @Override
        public String call() throws Exception {
            System.out.println("线程测试"+this.toString());
//            log.info("线程测试：{}", "Callable");
//            Thread.sleep(10000);
            return "Callable";
        }
    }
    //继承Thread类
    class Thread3 extends Thread {

        @Override
        public void run() {
            super.run();
        }
    }
}
