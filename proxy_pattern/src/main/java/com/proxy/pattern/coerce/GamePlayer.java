package com.proxy.pattern.coerce;

import com.proxy.pattern.IGamePlayerCoerce;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description TODO
 * @ClassName GamePlayer
 * @Author Liumh
 * @Date 2018/9/19 14:23
 * @Version v1.0
 */
@Slf4j
public class GamePlayer implements IGamePlayerCoerce {

    //代理
    private GamePlayerProxy gamePlayerProxy = null;

    private String name = "";

    public GamePlayer(String name) {
        this.name = name;
    }

    public IGamePlayerCoerce getProxy(){
        this.gamePlayerProxy = new GamePlayerProxy(this);
        return this.gamePlayerProxy;
    }

    @Override
    public void login(String user, String password) {
        if (isProxy()){
            log.info("登录名为：{}的用户{}登录成功", user, this.name);
        }else {
            log.error("请使用指定代理用户");
        }
    }

    @Override
    public void killBoss() {
        if (isProxy()){
            log.info("用户{}正在打怪", this.name);
        }else {
            log.error("请使用指定代理用户");
        }
    }

    @Override
    public void upGrade() {
        if (isProxy()){
            log.info("用户{}正在升级", this.name);
        }else {
            log.error("请使用指定代理用户");
        }
    }

    private boolean isProxy(){
        if (this.gamePlayerProxy == null){
            return false;
        }else {
            return true;
        }
    }
}
