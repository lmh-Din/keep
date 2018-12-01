package com.learning.thread.pkt;

/**
 * @Description 守护线程测试
 * @ClassName DaemonThreadTest
 * @Author Liumh
 * @Date 2018/11/30 14:45
 * @Version v1.0
 */
public class DaemonThreadTest {

    public static void main(String[] args){
        /*
        守护线程随着主线程的消亡而消亡
         */
        Thread thread = new DaemonThread();
        thread.setDaemon(true);
        thread.start();
        try {
            thread.sleep(20000);
            System.out.println("Thread is excited");
            return;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class DaemonThread extends Thread{

    private int i = 0;

    @Override
    public void run() {
        try {
            while (true){
                i++;
                System.out.println("i: "+ i);
                Thread.sleep(100);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
