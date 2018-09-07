package com.builder.pattern;

import lombok.Data;

/**
 * @Description 程序
 * @ClassName Programer
 * @Author Liumh
 * @Date 2018/9/7 13:42
 * @Version v1.0
 */
@Data
public class Programer {

    private String languageForUse;
    private String platformForUse;
    private String ideForUse;

    public String printProgramer(){
        StringBuffer programer = new StringBuffer();
        programer.append("我是使用").append(languageForUse).append("语言，");
        programer.append("基于").append(ideForUse).append("开发工具，");
        programer.append("在").append(platformForUse).append("上开发的！");
        return programer.toString();
    }
}
