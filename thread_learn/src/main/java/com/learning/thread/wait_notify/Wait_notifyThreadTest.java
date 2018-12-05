package com.learning.thread.wait_notify;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @ClassName Wait_notifyThreadTest
 * @Author Liumh
 * @Date 2018/12/5 14:51
 * @Version v1.0
 */
public class Wait_notifyThreadTest {

    public static void main(String[] args){
        Object lock = new Object();
        WaitThread waitThread = new WaitThread(lock);
        notifyThread notifyThread = new notifyThread(lock);
        waitThread.start();
        notifyThread.start();
    }

}

class Queue{

    private static List<Object> list = new ArrayList<>();

    public static void add(){
        list.add("anything");
    }

    public static int size(){
        return list.size();
    }

}

/*
    当线程状态为wait，对线程对象调用interrupt方法会出现interruptException异常
 */
class WaitThread extends Thread{

    private Object lock;

    public WaitThread(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock){
                if (Queue.size() != 5){
                    System.out.println("wait begin : "+System.currentTimeMillis());
                    lock.wait();
                    System.out.println("wait over : "+System.currentTimeMillis());
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

/**
 * notify完成后不会立马释放对象锁
 */
class notifyThread extends Thread{
    private Object lock;

    public notifyThread(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock){
                for (int i=0;i<10;i++){
                    Queue.add();
                    if (Queue.size() == 5){
                        lock.notify();
                        System.out.println("已发出唤醒通知");
//                        break;
                    }
                    System.out.println("已经添加了："+(i+1)+"个元素");
                    Thread.sleep(1000);
                }
                /*
                    当方法wait()被执行后，锁自动被释放，但执行完notify()方法后，锁不会自动释放。
                    必须执行完notify()方法所在的synchronized代码块后才释放
                 */
                System.out.println("notify所在synchronized代码块执行完毕，正式释放锁。。。");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
