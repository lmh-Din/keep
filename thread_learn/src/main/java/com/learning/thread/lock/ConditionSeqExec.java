package com.learning.thread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description
 * @ClassName ConditionSeqExec
 * @Author Liumh
 * @Date 2018/12/12 16:02
 * @Version v1.0
 */
public class ConditionSeqExec {

    private volatile static int nextPrintWho = 1;

    private static Lock lock = new ReentrantLock();

    private final static Condition conditionA = lock.newCondition();
    private final static Condition conditionB = lock.newCondition();
    private final static Condition conditionC = lock.newCondition();

    public static void main(String[] args){
        Thread threadA = new Thread(){
            @Override
            public void run() {
                lock.lock();
                try {

                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        };
    }



}
