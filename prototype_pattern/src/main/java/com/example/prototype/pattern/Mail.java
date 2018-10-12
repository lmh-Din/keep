package com.example.prototype.pattern;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

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

    /**
     * 深拷贝：讲对象及对象内部的所有成员变量全部拷贝，互相之间不再产生任何影响
     *
     * 浅拷贝：只拷贝当前对象本身和对象内部基本类型的成员变量（在这里String也被认为是基本类型）
     */
    private ArrayList<String> list = new ArrayList<>();

    @Override
    protected Mail clone() throws CloneNotSupportedException {
        Mail mail = null;
        try {
            mail = (Mail) super.clone();
            this.list = (ArrayList<String>) this.list.clone();
        }catch (Exception e){
            e.printStackTrace();
        }
        return mail;
    }
}
