package com.learning.aqs;

import java.util.PrimitiveIterator;
import java.util.concurrent.*;

/**
 * @Description AQS测试
 * @ClassName AQSTest
 * @Author Liumh
 * @Date 2019/2/28 11:09
 * @Version v1.0
 */
public class AQSTest {

    private static final int totalThread = 10;

    public static void main(String[] args) throws InterruptedException {
//        countDownLatch();
//        cyclicBarrier();
        semaphore();
    }

    /**
     * 维护了一个计数器 cnt，每次调用 countDown() 方法会让计数器的值减 1，减到 0 的时候，那些因为调用 await() 方法而在等待的线程就会被唤醒
     */
    private static void countDownLatch() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(totalThread);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i=0; i<totalThread; i++){
            executorService.execute(() -> {
                System.out.println("run...");
                try {
                    System.out.println("Thread sleep, currentTime:"+System.currentTimeMillis());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        System.out.println("end...");
        executorService.shutdown();
    }

    /**
     * 用来控制多个线程互相等待，只有当多个线程都到达时，这些线程才会继续执行。
     * 和 CountdownLatch 相似，都是通过维护计数器来实现的。线程执行 await() 方法之后计数器会减 1，并进行等待，直到计数器为 0，所有调用 await() 方法而在等待的线程才能继续执行
     * CyclicBarrier 和 CountdownLatch 的一个区别是，CyclicBarrier 的计数器通过调用 reset() 方法可以循环使用，所以它才叫做循环屏障
     */
    private static void cyclicBarrier(){
        CyclicBarrier cyclicBarrier = new CyclicBarrier(totalThread);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i=0; i<totalThread; i++){
            executorService.execute(() -> {
                System.out.println("before...");
                try {
                    int num = cyclicBarrier.await();
//                    System.out.println("totalThread num:"+num);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println("after...");
            });
        }
        executorService.shutdown();
    }

    private static void semaphore(){
        final int clientCount = 3;
        final int totalRequestCount = 10;

        Semaphore semaphore = new Semaphore(clientCount);

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < totalRequestCount; i++){
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(semaphore.availablePermits()+"");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            });
        }
        executorService.shutdown();
    }

}
