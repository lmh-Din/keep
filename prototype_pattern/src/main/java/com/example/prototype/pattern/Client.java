package com.example.prototype.pattern;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description TODO
 * @ClassName Client
 * @Author Liumh
 * @Date 2018/9/25 14:25
 * @Version v1.0
 */
@Slf4j
public class Client {

    public static void main(String[] args){
        try {
            AdvTemplate template = new AdvTemplate("主题","内容");
            Mail mail = new Mail(template);
            log.info(mail.toString());
            Mail mail1 = mail.clone();
            mail1.setContext("aaaaaa");
            log.info(mail1.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
