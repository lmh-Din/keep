package com.learning.thread.communication;

import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * @Description
 * @ClassName PipCommunicationTest
 * @Author Liumh
 * @Date 2018/12/5 16:30
 * @Version v1.0
 */
public class PipCommunicationTest {

    public static void main(String[] args){
        try {
            PipCommunicationTest pipCommunicationTest = new PipCommunicationTest();

            PipedInputStream inputStream = new PipedInputStream();
            PipedOutputStream outputStream = new PipedOutputStream();

            //使两个管道产生连接，数据可以进行输入输出
            outputStream.connect(inputStream);

            Thread write = new ThreadWrite(pipCommunicationTest, outputStream);
            write.start();

            Thread.sleep(1000);

            Thread read = new ThreadRead(pipCommunicationTest, inputStream);
            read.start();


        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void writeMethod(PipedOutputStream outputStream){
        try {
            System.out.println("write method begin...");
            for (int i=0; i<300; i++){
                String outData = "" + i;
                outputStream.write(outData.getBytes());
                System.out.print(""+outData);
            }
            System.out.println();
            outputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void readMethod(PipedInputStream inputStream) throws Exception{
        System.out.println("read method begin...");
        byte[] bytes = new byte[20];
        int readLength = 0;
        while ((readLength = inputStream.read(bytes, 0, 20)) != -1){
            String readData = new String(bytes, 0 ,readLength);
            System.out.print(""+readData);
        }
        System.out.println();
        inputStream.close();
    }
}

class ThreadRead extends Thread{

    private PipCommunicationTest pipCommunicationTest;

    private PipedInputStream inputStream;

    public ThreadRead(PipCommunicationTest pipCommunicationTest, PipedInputStream inputStream) {
        this.pipCommunicationTest = pipCommunicationTest;
        this.inputStream = inputStream;
    }

    @Override
    public void run() {
        try {
            pipCommunicationTest.readMethod(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ThreadWrite extends Thread{

    private PipCommunicationTest pipCommunicationTest;

    private PipedOutputStream outputStream;

    public ThreadWrite(PipCommunicationTest pipCommunicationTest, PipedOutputStream outputStream) {
        this.pipCommunicationTest = pipCommunicationTest;
        this.outputStream = outputStream;
    }

    @Override
    public void run() {
        super.run();
        pipCommunicationTest.writeMethod(outputStream);
    }
}
