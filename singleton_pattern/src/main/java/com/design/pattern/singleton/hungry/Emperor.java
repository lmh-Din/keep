package com.design.principle.srp.hungry;

/**
 * @Description 饿汉式单例
 * @ClassName Emperor
 * @Author Liumh
 * @Date 2018/9/11 20:27
 * @Version v1.0
 */
public class Emperor {

    private static final Emperor EMPEROR = new Emperor();

    /**
     * 私有化构造方法，不能通过new创建实例
     */
    private Emperor() {
    }

    public static Emperor getInstance(){
        return EMPEROR;
    }
}
