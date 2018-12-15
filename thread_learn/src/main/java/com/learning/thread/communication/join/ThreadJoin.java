package com.learning.thread.communication.join;

/**
 * @Description 
 * @ClassName ThreadNotJoin
 * @Author Liumh
 * @Date 2018/12/10 13:28
 * @Version v1.0
 */
public class ThreadJoin {

    public static void main(String[] args){
        try {
            Thread thread = new ThreadJoinA();
            thread.start();
            /*
                问题
                主线程运行需要使用子线程的结果，如果知道子线程的运行时间可以使用sleep等待进行处理，
                如果不确定子线程的运行时间这里就需要使用join进行处理

                sleep和join的区别在于：sleep不会释放锁，join会释放锁
             */
            thread.join(2000);
//            Thread.sleep(100);
            System.out.println("main-thread stop timer："+System.currentTimeMillis());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 静态内部类
     */
    static public class ThreadJoinA extends Thread{
        @Override
        public void run() {
            try {
                System.out.println("son-thread start timer："+System.currentTimeMillis());
                Thread.sleep(10000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
