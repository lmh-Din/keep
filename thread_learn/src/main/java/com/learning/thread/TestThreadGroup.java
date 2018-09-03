package com.learning.thread;

/**
 * @Description TODO
 * @ClassName TestThreadGroup
 * @Author Liumh
 * @Date 2018/9/3 10:16
 * @Version v1.0
 */
public class TestThreadGroup {

    public static void main(String[] args){
        Thread thread1 = new TestThread();
        ThreadGroup threadGroup = thread1.getThreadGroup();
        System.out.println(threadGroup.getName());
        System.out.println(threadGroup.getParent());
    }
}
