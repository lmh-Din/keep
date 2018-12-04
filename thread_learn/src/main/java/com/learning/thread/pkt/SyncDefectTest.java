package com.learning.thread.pkt;

/**
 * @Description
 * @ClassName SyncDefectTest
 * @Author Liumh
 * @Date 2018/12/4 13:21
 * @Version v1.0
 */
public class SyncDefectTest {

    public static void main(String[] args){
        SyncDefectTask task = new SyncDefectTask();
        Thread thread1 = new SyncDefectThread1(task);
        thread1.setName("thread1");
        thread1.start();

        Thread thread2 = new SyncDefectThread2(task);
        thread2.setName("thread2");
        thread2.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long beginTime = SyncDefectEntity.beginTime1;
        if (SyncDefectEntity.beginTime2 < SyncDefectEntity.beginTime1) {
            beginTime = SyncDefectEntity.beginTime2;
        }

        long endTime = SyncDefectEntity.endTime1;
        if (SyncDefectEntity.endTime2 > SyncDefectEntity.endTime1) {
            endTime = SyncDefectEntity.endTime2;
        }

        System.out.println("耗时：" + ((endTime - beginTime) / 1000));

    }

}

class SyncDefectThread1 extends Thread{
    private SyncDefectTask task;

    public SyncDefectThread1(SyncDefectTask task) {
        this.task = task;
    }

    @Override
    public void run() {
        super.run();
        SyncDefectEntity.beginTime1 = System.currentTimeMillis();
        task.doLongTask();
        SyncDefectEntity.endTime1 = System.currentTimeMillis();
    }
}

class SyncDefectThread2 extends Thread{

    private SyncDefectTask task;

    public SyncDefectThread2(SyncDefectTask task) {
        this.task = task;
    }

    @Override
    public void run() {
        super.run();
        SyncDefectEntity.beginTime2 = System.currentTimeMillis();
        task.doLongTask();
        SyncDefectEntity.endTime2 = System.currentTimeMillis();
    }
}

class SyncDefectEntity{

    public static long beginTime1;
    public static long beginTime2;

    public static long endTime1;
    public static long endTime2;

}

class SyncDefectTask{

    private static String taskData1;
    private static String taskData2;

    //同步方法
    /*public synchronized static void doLongTask(){
        try {
            System.out.println("task begin....");
            Thread.sleep(3000);
            taskData1 = "长时间处理任务后返回的值1，ThreadName："+Thread.currentThread().getName();
            taskData2 = "长时间处理任务后返回的值2，ThreadName："+Thread.currentThread().getName();
            System.out.println(taskData1);
            System.out.println(taskData2);
            System.out.println("end task");
        }catch (Exception e){
            e.printStackTrace();
        }
    }*/

    //同步代码块
    // 同步代码块如果使用的是同一个对象监视器，是能够达到同步效果的，否则不然
    //synchronized关键字加到static静态方法和synchronized(class)代码块上都是是给Class类上锁，
    // 而synchronized关键字加到非static静态方法上是给对象上锁
    public void doLongTask(){
        try {
            System.out.println("task begin....");
            Thread.sleep(3000);
            String getData1 = "长时间处理任务后返回的值1，ThreadName："+Thread.currentThread().getName();
            String getData2 = "长时间处理任务后返回的值2，ThreadName："+Thread.currentThread().getName();
            synchronized (this){
                taskData1 = getData1;
                taskData2 = getData2;
            }
            System.out.println(taskData1);
            System.out.println(taskData2);
            System.out.println("end task");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
