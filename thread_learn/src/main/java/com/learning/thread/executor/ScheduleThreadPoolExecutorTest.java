package com.learning.thread.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @ClassName ScheduleThreadPoolExecutorTest
 * @Author Liumh
 * @Date 2018/12/15 11:16
 * @Version v1.0
 */
public class ScheduleThreadPoolExecutorTest {

    public static void main(String[] args) throws Exception{
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        System.out.println("current time:"+System.currentTimeMillis());
        for (int i=0; i<10; i++){
            Thread.sleep(1000);
            ScheduleWorker worker = new ScheduleWorker("do heavy processing");
            //创建并执行在给定延迟后启用的单次操作
            scheduledExecutorService.schedule(worker, 10, TimeUnit.SECONDS);
        }
        //添加延迟让调度程序产生一些线程
        Thread.sleep(30000);
        System.out.println("current time: "+System.currentTimeMillis());
        //关闭线程池
        scheduledExecutorService.shutdown();
        while (!scheduledExecutorService.isTerminated()){
            //等待所有线程执行完毕
        }
        System.out.println("end timer:"+System.currentTimeMillis());
    }

}

class ScheduleWorker implements Runnable{

    private String command;

    public ScheduleWorker(String command) {
        this.command = command;
    }

    @Override
    public void run() {
        System.out.println("Thread Name:"+Thread.currentThread().getName()+" start timer:"+System.currentTimeMillis());
        this.processCommand();
        System.out.println("Thread Name:"+Thread.currentThread().getName()+" end timer:"+System.currentTimeMillis());
    }

    private void processCommand(){
        try {
            Thread.sleep(2000);
        }catch (Exception e){

        }
    }

    @Override
    public String toString() {
        return this.command;
    }
}
