package com.example.prototype.pattern;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description TODO
 * @ClassName Mail
 * @Author Liumh
 * @Date 2018/9/25 13:49
 * @Version v1.0
 */
@Data
@Slf4j
public class Mail implements Cloneable {

    public Mail(AdvTemplate advTemplate) {
        log.info("构造函数执行");
        this.subject = advTemplate.getSubject();
        this.context = advTemplate.getContext();
    }

    /**
     * 接收者
     */
    private String receiver;
    /**
     * 称谓
     */
    private String appletation;
    /**
     * 主题
     */
    private String subject;
    /**
     * 内容
     */
    private String context;

    private String tail;

    @Override
    protected Mail clone() throws CloneNotSupportedException {
        return (Mail) super.clone();
    }
}
