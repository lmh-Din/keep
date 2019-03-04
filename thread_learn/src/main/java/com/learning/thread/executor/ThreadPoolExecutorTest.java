package com.learning.thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description 线程池测试：FixedThreadPool
 * @ClassName ThreadPoolExecutorTest
 * @Author Liumh
 * @Date 2018/12/15 10:05
 * @Version v1.0
 */
public class ThreadPoolExecutorTest {

    public static void main(String[] args){
        //创建fixedThreadPool对象
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i=0; i<10; i++){
            //创建Runnable对象
            Runnable runnable = new RunnableWorker(i+"");
            //执行Runnable的run
            executorService.execute(runnable);
        }
        /*
        shutdown（）方法表明关闭已在Executor上调用，因此不会再向DelayedPool添加任何其他任务（由ScheduledThreadPoolExecutor类在内部使用）。
        但是，已经在队列中提交的任务将被允许完成。
        另一方面，shutdownNow（）方法试图终止当前正在运行的任务，并停止处理排队的任务并返回正在等待执行的List
         */
        //终止线程池
        executorService.shutdown();
        /*
        isShutdown（）表示执行程序正在关闭，但并非所有任务都已完成执行。
        另一方面，isTerminated（）表示所有线程都已完成执行
         */
        while (!executorService.isTerminated()){
            System.out.println("ThreadPool is running");
        }
        System.out.println("All Thread is terminated");
    }

}

class RunnableWorker implements Runnable{

    private String command;

    public RunnableWorker(String command) {
        this.command = command;
    }

    @Override
    public void run() {
        System.out.println("Thread Name:"+Thread.currentThread().getName()+", start timer:"+System.currentTimeMillis());
        this.processCommand();
        System.out.println("Thread Name:"+Thread.currentThread().getName()+", end timer:"+System.currentTimeMillis());

    }

    private void processCommand(){
        try {
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.command;
    }
}
