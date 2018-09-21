package com.proxy.pattern;

import com.proxy.pattern.coerce.GamePlayer;
import com.proxy.pattern.common.GamePlayerProxy;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description TODO
 * @ClassName ProxyClient
 * @Author Liumh
 * @Date 2018/9/20 9:47
 * @Version v1.0
 */
@Slf4j
public class ProxyClient {

    public static void main(String[] args){
        commonProxy();
        coerceProxy();
    }

    /**
     * 普通代理
     */
    private static void commonProxy(){
        IGamePlayerCommon commonProxy = new GamePlayerProxy("普通代理用户");
        commonProxy.login("aaa", "bbb");
        commonProxy.killBoss();
        commonProxy.upGrade();
    }

    /**
     * 强制代理
     */
    private static void coerceProxy(){
        GamePlayer gamePlayer = new GamePlayer("强制代理用户");
        IGamePlayerCoerce coerceProxy = gamePlayer.getProxy();
        coerceProxy.login("ccc", "ddd");
        coerceProxy.killBoss();
        coerceProxy.upGrade();
    }
}
