package com.proxy.pattern.extension;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;

/**
 * @Description TODO
 * @ClassName DynamicClient
 * @Author Liumh
 * @Date 2018/9/21 9:56
 * @Version v1.0
 */
@Slf4j
public class DynamicClient {

    public static void main(String[] args){
        clientTest();
//        methodTest();
    }

    private static void clientTest(){
        Subject subject = new RealSubject();
        InvocationHandler invocationHandler = new MyInvocationHandler(subject);
        Subject proxy = DynamicProxy.newProxyInstance(subject.getClass().getClassLoader(),
                subject.getClass().getInterfaces(), invocationHandler);
        proxy.doSomeThing();
    }

    public static void methodTest(){
        SecurityManager sm = System.getSecurityManager();
        Subject subject = new RealSubject();
        Class subj = subject.getClass();
        ClassLoader cl = subj.getClassLoader();
        ClassLoader pcl = cl.getParent();
        Class[] clzs = subject.getClass().getClasses();
        Class[] ints = subject.getClass().getInterfaces();
        log.info("***********");
    }
}
