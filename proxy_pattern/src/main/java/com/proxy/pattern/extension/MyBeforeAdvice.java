package com.proxy.pattern.extension;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description TODO
 * @ClassName MyBeforeAdvice
 * @Author Liumh
 * @Date 2018/9/21 9:48
 * @Version v1.0
 */
@Slf4j
public class MyBeforeAdvice implements MyAdvice {

    @Override
    public void exec() {
        log.info("这里是前置通知");
    }

}
