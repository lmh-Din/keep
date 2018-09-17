package com.design.principle.srp.lazy;


/**
 * @Description 懒汉式单例（线程并发高的情况下会出现线程同步问题）
 * @ClassName Emperor
 * @Author Liumh
 * @Date 2018/9/11 20:27
 * @Version v1.0
 */
public class Emperor {

    private static Emperor emperor = null;

    /**
     * 私有化构造方法，不能通过new创建实例
     */
    private Emperor() {
    }

    public static Emperor getInstance(){
        if (emperor == null){
            emperor = new Emperor();
        }
        return emperor;
    }
}
