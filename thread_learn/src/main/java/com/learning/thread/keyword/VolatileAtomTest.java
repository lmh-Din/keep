package com.learning.thread.keyword;

/**
 * @Description Volatile原子性测试
 * @ClassName VolatileAtomTest
 * @Author Liumh
 * @Date 2018/12/5 11:04
 * @Version v1.0
 */
public class VolatileAtomTest {

    /*
        《Java并发编程艺术》这本书上说保证但是在自增操作（非原子操作）上不保证？？？
        volatile无法保证对变量原子性的？？？

        synchronized关键字、Lock、atomic类均可以保证数据操作的原子性
     */

    /*
        volatile关键字是线程同步的轻量级实现，所以volatile性能肯定比synchronized关键字要好。
        但是volatile关键字只能用于变量而synchronized关键字可以修饰方法以及代码块。
        synchronized关键字在JavaSE1.6之后进行了主要包括为了减少获得锁和释放锁带来的性能消耗而引入的偏向锁和轻量级锁
        以及其它各种优化之后执行效率有了显著提升，实际开发中使用synchronized关键字还是更多一些

        多线程访问volatile关键字不会发生阻塞，而synchronized关键字可能会发生阻塞

        volatile关键字能保证数据的可见性，但不能保证数据的原子性。synchronized关键字两者都能保证

        volatile关键字用于解决变量在多个线程之间的可见性，而ynchronized关键字解决的是多个线程之间访问资源的同步性
     */

    public static void main(String[] args){
        VolatileAtomThread[] threads = new VolatileAtomThread[100];
        for (int i=0;i<100;i++){
            threads[i] = new VolatileAtomThread();
        }

        for (int i=0;i<100;i++){
            threads[i].start();
        }
    }
}

class VolatileAtomThread extends Thread{

    public volatile static int count;

    @Override
    public void run() {
        super.run();
        for (int i=0;i<100;i++){
            count=i;
        }
        System.out.println("count = "+count);
    }

}
