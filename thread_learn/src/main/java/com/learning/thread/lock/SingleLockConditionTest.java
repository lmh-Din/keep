package com.learning.thread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description
 * @ClassName SingleLockConditionTest
 * @Author Liumh
 * @Date 2018/12/12 10:42
 * @Version v1.0
 */
public class SingleLockConditionTest {

    /*
    在使用wait/notify实现等待通知机制的时候我们知道必须执行完notify()
    方法所在的synchronized代码块后才释放锁。在这里也差不多，
    必须执行完signal所在的try语句块之后才释放锁，condition.await()后的语句才能被执行

    注意： 必须在condition.await()方法调用之前调用lock.lock()代码获得同步监视器，不然会报错
     */

    public static void main(String[] args) throws Exception{
        SingleLockCondition singleLockCondition = new SingleLockCondition();
        SingleLockConditionThread thread = new SingleLockConditionThread(singleLockCondition);
        thread.start();

        Thread.sleep(3000);

        singleLockCondition.signal();

        System.out.println("main over.....");
    }
}

class SingleLockConditionThread extends Thread{

    private SingleLockCondition singleLockCondition;

    public SingleLockConditionThread(SingleLockCondition singleLockCondition) {
        this.singleLockCondition = singleLockCondition;
    }

    @Override
    public void run() {
        super.run();
        singleLockCondition.await();
    }
}

class SingleLockCondition{

    private Lock lock = new ReentrantLock();

    public Condition condition = lock.newCondition();

    public void await(){
        lock.lock();
        try {
            System.out.println("await timer："+System.currentTimeMillis());
            condition.await();
            System.out.println("await method process："+System.currentTimeMillis());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void signal(){
        lock.lock();
        try {
            System.out.println("signal timer："+System.currentTimeMillis());
            condition.signal();
            Thread.sleep(3000);
            System.out.println("signal method process："+System.currentTimeMillis());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
