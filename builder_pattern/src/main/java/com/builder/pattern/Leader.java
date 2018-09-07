package com.builder.pattern;

import com.builder.pattern.concrete.ServerCoder;
import com.builder.pattern.enums.Computer;
import com.builder.pattern.enums.IDE;
import com.builder.pattern.enums.Language;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description 指挥者（Director）
 * @ClassName Leader
 * @Author Liumh
 * @Date 2018/9/6 15:03
 * @Version v1.0
 */
@Slf4j
public class Leader {

    public static void main(String[] args){
        String serverMsg = buildeServerCoder();
        log.info("serverMsg:{}", serverMsg.toString());

        String frontMsg = buildeFrontCoder();
        log.info("frontMsg:{}", frontMsg.toString());
    }

    private static String buildeServerCoder(){
        Coder serverCoder = new ServerCoder();
        serverCoder.withLanguage(Language.Java).withComputer(Computer.MBP)
                .withIDE(IDE.IDEA);
        return serverCoder.code().toString();
    }

    private static String buildeFrontCoder(){
        Coder frontCoder = new ServerCoder();
        frontCoder.withLanguage(Language.Node).withComputer(Computer.MBP)
                .withIDE(IDE.HBuider);
        return frontCoder.code().toString();
    }
}
