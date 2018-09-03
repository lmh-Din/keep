package com.learning.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;

/**
 * @Description TODO
 * @ClassName TestCallable
 * @Author Liumh
 * @Date 2018/8/29 11:02
 * @Version v1.0
 */
@Slf4j
public class TestCallable implements Callable<Integer> {

    private Integer ticketNum = 100;

    @Override
    public Integer call() throws Exception {
        while (true){
            if (ticketNum > 0){
                Integer ticket = ticketNum--;
                log.info("正在出售第{}张票", ticket);
                return ticket;
            }
        }
    }

}
