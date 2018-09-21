package com.proxy.pattern.extension;

import org.springframework.aop.BeforeAdvice;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @Description 动态代理类
 * @ClassName DynamicProxy
 * @Author Liumh
 * @Date 2018/9/21 9:39
 * @Version v1.0
 */
public class DynamicProxy {

    public static Subject newProxyInstance(ClassLoader classLoader, Class[] classes,
                              InvocationHandler invocationHandler){
        //寻找切入点，
        if (true){
            //执行前置通知
            (new MyBeforeAdvice()).exec();
        }
        //执行目标，返回结果
        return (Subject) Proxy.newProxyInstance(classLoader, classes, invocationHandler);
    }
}
