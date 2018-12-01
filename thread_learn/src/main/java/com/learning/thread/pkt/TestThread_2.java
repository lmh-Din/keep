package com.learning.thread.pkt;

/**
 * @Description 变量多线程间共享，存在线程安全问题
 * @ClassName TestThread_1
 * @Author Liumh
 * @Date 2018/11/30 11:09
 * @Version v1.0
 */
public class TestThread_2 extends Thread {
    int count = 5;

    public TestThread_2(String name){
        super();
        this.setName(name);
    }

    public TestThread_2(){
        super();
    }

    @Override
    public void run() {
        while (count > 0){
            System.out.println(Thread.currentThread().getName()+" : "+count);
            count--;
        }
    }

    public static void main(String[] args){
        TestThread_2 thread_2 = new TestThread_2();
        Thread thread1 = new Thread(thread_2,"A");
        Thread thread2 = new Thread(thread_2,"B");
        Thread thread3 = new Thread(thread_2,"C");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
