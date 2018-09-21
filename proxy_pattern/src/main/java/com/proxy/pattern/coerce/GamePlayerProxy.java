package com.proxy.pattern.coerce;

import com.proxy.pattern.IGamePlayerCoerce;

/**
 * @Description TODO
 * @ClassName GamePlayerProxy
 * @Author Liumh
 * @Date 2018/9/19 14:24
 * @Version v1.0
 */
public class GamePlayerProxy implements IGamePlayerCoerce {

    private IGamePlayerCoerce gamePlayer = null;

    public GamePlayerProxy(IGamePlayerCoerce gamePlayer) {
        this.gamePlayer = gamePlayer;
    }

    @Override
    public void login(String user, String password) {
        gamePlayer.login(user, password);
    }

    @Override
    public void killBoss() {
        gamePlayer.killBoss();
    }

    @Override
    public void upGrade() {
        gamePlayer.upGrade();
    }

    @Override
    public IGamePlayerCoerce getProxy() {
        return this;
    }
}
