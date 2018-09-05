package com.design.pattern.factory_method.entity;

/**
 * @Description 本田
 * @ClassName Honda
 * @Author Liumh
 * @Date 2018/9/5 15:30
 * @Version v1.0
 */
public class Honda implements Car {

    @Override
    public void carMsg() {
        System.out.println("我是本田汽车");
    }
}
