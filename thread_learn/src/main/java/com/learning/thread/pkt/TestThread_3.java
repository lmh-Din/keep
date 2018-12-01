package com.learning.thread.pkt;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description 使用AtomicInteger/synchronized
 * @ClassName TestThread_1
 * @Author Liumh
 * @Date 2018/11/30 11:09
 * @Version v1.0
 */
public class TestThread_3 extends Thread {

    AtomicInteger count = new AtomicInteger(5);

    public TestThread_3(String name){
        super();
        this.setName(name);
    }

    public TestThread_3(){
        super();
    }

    @Override
    public void run() {
        while (count.get() > 0){
            System.out.println(Thread.currentThread().getName()+" : "+count.get());
            count.getAndDecrement();
        }
    }

    public static void main(String[] args){
        TestThread_3 thread_2 = new TestThread_3();
        Thread thread1 = new Thread(thread_2,"A");
        Thread thread2 = new Thread(thread_2,"B");
        Thread thread3 = new Thread(thread_2,"C");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
