package com.learning.thread.pkt;

import javax.xml.crypto.Data;
import java.util.Date;

/**
 * @Description 线程终止测试
 * @ClassName InterruptThreadTest
 * @Author Liumh
 * @Date 2018/11/30 13:38
 * @Version v1.0
 */
public class InterruptThreadTest extends Thread {

    /*@Override
    public void run() {
        super.run();
        for (int i=0;i<500;i++){
            if (this.isInterrupted()){
                System.out.println("execute interrupt，system will exited!!");
                break;
            }
            System.out.println("i="+i+1);
        }
        System.out.println("system is not exited!");
    }*/

    @Override
    public void run() {
        super.run();
        while (true){
            if (this.isInterrupted()){
                System.out.println("Thread is excited");
                return;
            }
            System.out.println("CurrentTime: "+ System.currentTimeMillis());
        }
    }

    public static void main(String[] args){
        try {
            Thread thread = new InterruptThreadTest();
            thread.start();
            System.out.println("Thread is started");
            Thread.sleep(2000);
            thread.interrupt();

        }catch (Exception e){

        }
    }
}
