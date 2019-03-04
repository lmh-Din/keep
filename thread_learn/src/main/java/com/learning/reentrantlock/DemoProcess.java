package com.learning.reentrantlock;

import com.learning.base.ThreadDemo;

/**
 * @Description
 * @ClassName DemoProcess
 * @Author Liumh
 * @Date 2019/2/20 10:18
 * @Version v1.0
 */
public class DemoProcess {

    public static void main(String[] args){
//        reentrantLockTest1();
        reentrantLockTest2();
    }

    private static void reentrantLockTest1(){
        ReentrantLockDemo reentrantLockDemo = new ReentrantLockDemo();

        Thread thread1 = new Thread(new ThreadDemo(reentrantLockDemo, "func"));
        Thread thread2 = new Thread(new ThreadDemo(reentrantLockDemo, "func"));

        thread1.start();
        thread2.start();
    }

    private static void reentrantLockTest2(){
        ReentrantLockDemo reentrantLockDemo = new ReentrantLockDemo();
        ReentrantLockDemo reentrantLockDemo2 = new ReentrantLockDemo();

        Thread thread1 = new Thread(new ThreadDemo(reentrantLockDemo, "func"));
        Thread thread2 = new Thread(new ThreadDemo(reentrantLockDemo2, "func"));

        thread1.start();
        thread2.start();
    }


}
