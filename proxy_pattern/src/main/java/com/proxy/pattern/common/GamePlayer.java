package com.proxy.pattern.common;

import com.proxy.pattern.IGamePlayerCommon;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description TODO
 * @ClassName GamePlayer
 * @Author Liumh
 * @Date 2018/9/19 13:31
 * @Version v1.0
 */
@Slf4j
public class GamePlayer implements IGamePlayerCommon {

    private String name = "";

    public GamePlayer(IGamePlayerCommon iGamePlayer, String name){
        if (iGamePlayer == null){
            throw new RuntimeException("不能创建真实角色");
        }else {
            this.name = name;
        }
    }

    public GamePlayer(){
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
