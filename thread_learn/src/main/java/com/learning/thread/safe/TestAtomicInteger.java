package com.learning.thread.safe;

import com.learning.thread.MyIntegerThread;

/**
 * @Description Integer线程安全类
 * @ClassName TestAtomicInteger
 * @Author Liumh
 * @Date 2018/9/4 10:10
 * @Version v1.0
 */
public class TestAtomicInteger {

    public static void main(String[] args){
        MyIntegerThread integerRunnable = new MyIntegerThread();

        Thread thread1 = new Thread(integerRunnable, "测试线程1");
        Thread thread2 = new Thread(integerRunnable, "测试线程2");

        thread1.start();
        thread2.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(MyIntegerThread.ai.get());
    }

}
