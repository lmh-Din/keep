package com.learning.thread.pkt;

/**
 * @Description 线程优先级测试
 * @ClassName PriotityThreadTest
 * @Author Liumh
 * @Date 2018/11/30 14:14
 * @Version v1.0
 */
public class PriotityThreadTest {

    public static void main(String[] args){
        System.out.println("CurrentThread priotity: "+ Thread.currentThread().getPriority());
        Thread.currentThread().setPriority(6);
        System.out.println("Updated CurrentThread priotity: "+ Thread.currentThread().getPriority());
        Thread thread = new Mythread1();
        thread.setPriority(Thread.MIN_PRIORITY);
        thread.start();
    }

}

class Mythread1 extends Thread{
    @Override
    public void run() {
        super.run();
        System.out.println("Mythread1 priority: "+this.getPriority());

        Thread thread2 = new Mythread2();
        thread2.start();
    }
}

/**
 * Thread2和Thread1的优先级相同（线程优先级具有继承特性）
 */
class Mythread2 extends Thread{
    @Override
    public void run() {
        super.run();
        System.out.println("Mythread2 priority: "+this.getPriority());
    }
}
