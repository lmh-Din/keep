package com.proxy.pattern.extension;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description 真实主题
 * @ClassName RealSubject
 * @Author Liumh
 * @Date 2018/9/21 9:21
 * @Version v1.0
 */
@Slf4j
public class RealSubject implements Subject {

    @Override
    public void doSomeThing() {
        log.info("业务操作。。。。。。");
    }

}
