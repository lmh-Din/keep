package com.learning.base;

import java.lang.reflect.Method;

/**
 * @Description
 * @ClassName ThreadDemo
 * @Author Liumh
 * @Date 2019/2/20 10:19
 * @Version v1.0
 */
public class ThreadDemo implements Runnable {

    private Object object;

    private String methodName;

    public ThreadDemo(Object object, String methodName) {
        this.object = object;
        this.methodName = methodName;
    }

    @Override
    public void run() {
        try {
            Method method = object.getClass().getMethod(methodName);
            method.invoke(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
