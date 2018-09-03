package com.learning;

import com.learning.thread.TestCallable;
import com.learning.thread.TestMoreThread;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Description TODO
 * @ClassName MoreThread
 * @Author Liumh
 * @Date 2018/8/30 10:46
 * @Version v1.0
 */
@Slf4j
public class MoreThread {

    public static void main(String[] args){
        try {

            TestMoreThread testMoreThread = new TestMoreThread();
            Thread thread1 = new Thread(testMoreThread, "窗口1");
            Thread thread2 = new Thread(testMoreThread, "窗口2");
            Thread thread3 = new Thread(testMoreThread, "窗口3");
            thread1.start();
            thread2.start();
            thread3.start();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
