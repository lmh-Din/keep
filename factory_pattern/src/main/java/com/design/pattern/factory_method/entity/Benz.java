package com.design.pattern.factory_method.entity;

/**
 * @Description TODO
 * @ClassName Benz
 * @Author Liumh
 * @Date 2018/9/5 15:31
 * @Version v1.0
 */
public class Benz implements Car {

    @Override
    public void carMsg() {
        System.out.println("我是奔驰汽车");
    }
}
