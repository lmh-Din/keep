package com.learning.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description TODO
 * @ClassName TestMoreThread
 * @Author Liumh
 * @Date 2018/8/30 11:00
 * @Version v1.0
 */
@Slf4j
public class TestMoreThread implements Runnable {

    private Integer ticketNum = 1000;

    @Override
    public void run() {
        while (true){
            if (ticketNum > 0){
                log.info("{}正在出售第{}张票", Thread.currentThread().getName(), ticketNum--);
            }else {
                log.info("无更多票");
                return;
            }
        }
    }
}
