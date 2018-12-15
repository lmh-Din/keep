package com.learning.thread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description
 * @ClassName LockConditiontest
 * @Author Liumh
 * @Date 2018/12/12 10:35
 * @Version v1.0
 */
public class LockConditiontest {

    public static void main(String[] args) throws Exception{
        LockCondition lockCondition = new LockCondition();

        Thread threadA = new LockConditionThreadA(lockCondition, "A");
        threadA.start();

        Thread threadB = new LockConditionThreadB(lockCondition, "B");
        threadB.start();

        Thread.sleep(1000);

        /*
        A接收到signal命令被唤醒，B未接收到signal几乎会一直运行下去
         */
        lockCondition.signalAll_A();
    }

}

class LockConditionThreadA extends Thread{

    private LockCondition lockCondition;

    public LockConditionThreadA(LockCondition lockCondition, String threadName) {
        this.lockCondition = lockCondition;
        this.setName(threadName);
    }

    @Override
    public void run() {
        super.run();
        lockCondition.awaitA();
    }

}

class LockConditionThreadB extends Thread{

    private LockCondition lockCondition;

    public LockConditionThreadB(LockCondition lockCondition, String threadName) {
        this.lockCondition = lockCondition;
        this.setName(threadName);
    }

    @Override
    public void run() {
        super.run();
        lockCondition.awaitB();
    }

}


class LockCondition{

    private Lock lock = new ReentrantLock();

    public Condition conditionA = lock.newCondition();
    public Condition conditionB = lock.newCondition();

    public void awaitA(){
        lock.lock();
        try {
            System.out.println("awaitA begin timer:"+System.currentTimeMillis()+
                    " Thread name:"+Thread.currentThread().getName());
            conditionA.await();
            System.out.println("awaitA end timer:"+System.currentTimeMillis());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void awaitB(){
        lock.lock();
        try {
            System.out.println("awaitB begin timer:"+System.currentTimeMillis()+
                    " Thread name:"+Thread.currentThread().getName());
            conditionB.await();
            System.out.println("awaitB end timer:"+System.currentTimeMillis());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void signalAll_A(){
        lock.lock();
        try {
            System.out.println("signalAll_A begin timer:"+System.currentTimeMillis());
            conditionA.signalAll();
            System.out.println("signalAll_A end timer:"+System.currentTimeMillis());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void signalAll_B(){
        lock.lock();
        try {
            System.out.println("signalAll_B begin timer:"+System.currentTimeMillis());
            conditionB.signalAll();
            System.out.println("signalAll_B end timer:"+System.currentTimeMillis());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
