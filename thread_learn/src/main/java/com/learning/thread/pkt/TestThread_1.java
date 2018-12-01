package com.learning.thread.pkt;

/**
 * @Description 变量不共享，不存在线程安全问题
 * @ClassName TestThread_1
 * @Author Liumh
 * @Date 2018/11/30 11:09
 * @Version v1.0
 */
public class TestThread_1 extends Thread {
    int count = 5;

    public TestThread_1(String name){
        super();
        this.setName(name);
    }
    @Override
    public void run() {
        while (count > 0){
            System.out.println(Thread.currentThread().getName()+" : "+count);
            count--;
        }
    }

    public static void main(String[] args){
        Thread thread1 = new TestThread_1("A");
        Thread thread2 = new TestThread_1("B");
        Thread thread3 = new TestThread_1("C");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
