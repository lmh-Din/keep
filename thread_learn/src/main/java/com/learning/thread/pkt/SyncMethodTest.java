package com.learning.thread.pkt;

/**
 * @Description
 * @ClassName SyncMethodTest
 * @Author Liumh
 * @Date 2018/11/30 16:09
 * @Version v1.0
 */
public class SyncMethodTest {
}

class SyncPrivateNum{
    private int num;

    public synchronized void increNum(String threadName){
        if (threadName.equals("a")){
            num = 100;

        }else if (threadName.equals("b")){

        }
    }
}
