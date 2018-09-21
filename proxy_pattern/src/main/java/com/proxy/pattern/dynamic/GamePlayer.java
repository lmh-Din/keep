package com.proxy.pattern.dynamic;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description TODO
 * @ClassName GamePlayer
 * @Author Liumh
 * @Date 2018/9/20 15:16
 * @Version v1.0
 */
@Slf4j
public class GamePlayer implements IGamePlayer {
    private String name = "";

    public GamePlayer(String name) {
        this.name = name;
    }

    @Override
    public void login(String user, String password) {
        log.info("登录名为：{}，的用户{}登录成功", user, this.name);
    }

    @Override
    public void killBoss() {
        log.info("{}在打怪", this.name);
    }

    @Override
    public void upGrade() {
        log.info("{}在升级", this.name);
    }
}
