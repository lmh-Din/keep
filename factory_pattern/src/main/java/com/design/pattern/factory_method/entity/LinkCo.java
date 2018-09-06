package com.design.pattern.factory_method.entity;

/**
 * @Description TODO
 * @ClassName LinkCo
 * @Author Liumh
 * @Date 2018/9/5 15:31
 * @Version v1.0
 */
public class LinkCo implements Car {

    @Override
    public void carMsg() {
        System.out.println("我是领克汽车");
    }
}
