package com.learning.reentrantlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description
 * @ClassName ReentrantLockDemo
 * @Author Liumh
 * @Date 2019/2/20 10:15
 * @Version v1.0
 */
public class ReentrantLockDemo {

    private Lock lock = new ReentrantLock();

    public void func(){
        lock.lock();
        try {
            for (int i=0; i<10; i++){
                System.out.println(i);
            }
        }finally {
            lock.unlock();
        }
    }
}
