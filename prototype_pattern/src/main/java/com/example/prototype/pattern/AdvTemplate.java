package com.example.prototype.pattern;


import lombok.Data;

/**
 * @Description 原型实体
 * @ClassName AdvTemplate
 * @Author Liumh
 * @Date 2018/9/25 13:49
 * @Version v1.0
 */
@Data
public class AdvTemplate {

    public AdvTemplate(String subject, String context) {
        this.subject = subject;
        Context = context;
    }

    private String subject;

    private String Context;
}
