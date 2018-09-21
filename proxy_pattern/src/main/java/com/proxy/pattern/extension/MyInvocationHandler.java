package com.proxy.pattern.extension;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Description 动态代理的Handler
 * @ClassName MyInvocationHandler
 * @Author Liumh
 * @Date 2018/9/21 9:23
 * @Version v1.0
 */
@Slf4j
public class MyInvocationHandler implements InvocationHandler {

    //被代理对象
    private Object target = null;

    //定义构造函数传入被代理对象
    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //执行被代理的方法
        return method.invoke(target, args);
    }

}
