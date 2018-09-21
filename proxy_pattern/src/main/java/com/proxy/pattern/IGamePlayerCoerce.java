package com.proxy.pattern;

/**
 * @Description TODO
 * @ClassName IGamePlayerCoerce
 * @Author Liumh
 * @Date 2018/9/20 13:46
 * @Version v1.0
 */
public interface IGamePlayerCoerce {

    void login(String user, String password);

    void killBoss();

    void upGrade();

    IGamePlayerCoerce getProxy();
}
