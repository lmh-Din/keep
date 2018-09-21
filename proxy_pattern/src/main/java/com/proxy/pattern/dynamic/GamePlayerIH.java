package com.proxy.pattern.dynamic;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description TODO
 * @ClassName GamePlayerIH
 * @Author Liumh
 * @Date 2018/9/20 14:08
 * @Version v1.0
 */
@Slf4j
public class GamePlayerIH implements InvocationHandler {
    //被代理者
    Class clz = null;
    //被代理实例
    Object obj = null;

    public GamePlayerIH(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        log.info("{}开始：{}", method.getName(), sdf.format(new Date()));
        Object result = method.invoke(obj, args);
        log.info("{}结束：{}", method.getName(), sdf.format(new Date()));
        return result;
    }
}
