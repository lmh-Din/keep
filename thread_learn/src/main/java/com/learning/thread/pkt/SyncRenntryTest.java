package com.learning.thread.pkt;

import javax.annotation.Resource;

/**
 * @Description synchronized重入测试
 *  同一个对象中的多个方法支持重入锁
 *  子父类的继承关系中也支持重入锁
 * @ClassName SyncRenntryTest
 * @Author Liumh
 * @Date 2018/12/3 13:19
 * @Version v1.0
 */
public class SyncRenntryTest {

    public static void main(String[] args){
        Thread thread = new ReentryThread();
        thread.start();
    }

}

class ReenTryTest{

    public synchronized void exec1(){
        System.out.println("exec1 method exec...");
        this.exec2();
    }
    public synchronized void exec2(){
        System.out.println("exec2 method exec...");
        this.exec3();
    }
    public synchronized void exec3(){
        System.out.println("exec3 method exec...");
    }
}

class ReentryThread extends Thread{

    @Override
    public void run() {
        super.run();
        ReenTryTest test = new ReenTryTest();
        test.exec1();
    }

}
