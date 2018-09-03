package com.learning.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description TODO
 * @ClassName LockThread
 * @Author Liumh
 * @Date 2018/8/30 15:39
 * @Version v1.0
 */
@Slf4j
public class DeadLockThread implements Runnable {

    private Integer flag = 0;

    private static Object obj1 = new Object(), obj2 = new Object();

    @Override
    public void run() {
        try {
            if (flag == 0){
                System.out.println(obj1);
                System.out.println(obj2);
                //线程等待
                synchronized (obj1){
                    log.info("{}线程执行：{}", Thread.currentThread().getName(), flag);
                    Thread.sleep(1000);
                    synchronized (obj2){
                        log.info("{}线程唤醒执行。。。", Thread.currentThread().getName());
                    }
                }
            }
            if (flag == 1){
                //线程等待
                synchronized (obj2){
                    log.info("{}线程执行：{}", Thread.currentThread().getName(), flag);
                    Thread.sleep(1000);
                    synchronized (obj1){
                        log.info("{}线程唤醒执行。。。", Thread.currentThread().getName());
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        DeadLockThread deadLockThread1 = new DeadLockThread();
        DeadLockThread deadLockThread2 = new DeadLockThread();
        Thread thread1 = new Thread(deadLockThread1, "线程1");
        Thread thread2 = new Thread(deadLockThread2, "线程2");
        deadLockThread1.flag = 0;
        deadLockThread2.flag = 1;
        thread1.start();
        thread2.start();
    }
}
