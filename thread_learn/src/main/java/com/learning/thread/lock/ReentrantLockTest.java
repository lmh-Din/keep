package com.learning.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description
 * @ClassName ReentrantLockTest
 * @Author Liumh
 * @Date 2018/12/10 16:27
 * @Version v1.0
 */
public class ReentrantLockTest {

    public static void main(String[] args){
        ReentrantLockService service = new ReentrantLockService();

        Thread thread1 = new ReenTrantThread(service);
        Thread thread2 = new ReenTrantThread(service);
        Thread thread3 = new ReenTrantThread(service);
        Thread thread4 = new ReenTrantThread(service);
        Thread thread5 = new ReenTrantThread(service);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }

}

class ReentrantLockService{
    private static Lock lock = new ReentrantLock();

    public void testMethod(){
        lock.lock();
        try {
            for (int i=0;i<5;i++){
                System.out.println("thread name："+Thread.currentThread().getName()+(" "+(i+1)));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}

class ReenTrantThread extends Thread{
    private ReentrantLockService reentrantLockService;

    public ReenTrantThread(ReentrantLockService reentrantLockService) {
        this.reentrantLockService = reentrantLockService;
    }

    @Override
    public void run() {
        super.run();
        reentrantLockService.testMethod();
    }
}
