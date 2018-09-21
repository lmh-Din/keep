package com.proxy.pattern.common;

import com.proxy.pattern.IGamePlayerCommon;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description TODO
 * @ClassName GamePlayerProxy
 * @Author Liumh
 * @Date 2018/9/19 11:29
 * @Version v1.0
 */
@Slf4j
public class GamePlayerProxy implements IGamePlayerCommon {

    private IGamePlayerCommon gamePlayer;

    public GamePlayerProxy(String name) {
        gamePlayer = new GamePlayer(this, name);
    }

    private GamePlayerProxy(){

    }

    @Override
    public void login(String user, String password) {
        this.gamePlayer.login(user, password);
    }

    @Override
    public void killBoss() {
        this.gamePlayer.killBoss();
    }

    @Override
    public void upGrade() {
        this.gamePlayer.upGrade();
    }
}
