package com.proxy.pattern.dynamic;


import java.lang.reflect.Proxy;

/**
 * @Description 动态代理测试
 * @ClassName DynamicProxyClient
 * @Author Liumh
 * @Date 2018/9/20 14:30
 * @Version v1.0
 */
public class DynamicProxyClient {

    public static void main(String[] args){
        dynamicInvoke();
    }

    private static void dynamicInvoke(){
        IGamePlayer gamePlayer = new GamePlayer("张三");
        //定义一个handle
        GamePlayerIH handle = new GamePlayerIH(gamePlayer);
        //获取类的classLoader
        ClassLoader clz = gamePlayer.getClass().getClassLoader();
        //动态产生一个代理者
        IGamePlayer proxy = (IGamePlayer) Proxy.newProxyInstance(clz, new Class[]{IGamePlayer.class}, handle);

        proxy.login("aaa", "bbbb");
        proxy.killBoss();
        proxy.upGrade();
    }

}
