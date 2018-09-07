package com.builder.pattern.concrete;

import com.builder.pattern.Coder;
import com.builder.pattern.CodingWith;
import com.builder.pattern.Programer;
import com.builder.pattern.enums.Computer;
import com.builder.pattern.enums.IDE;
import com.builder.pattern.enums.Language;

/**
 * @Description 服务端开发
 * @ClassName ServerCoder
 * @Author Liumh
 * @Date 2018/9/6 15:13
 * @Version v1.0
 */
public class ServerCoder extends CodingWith implements Coder {

    private Programer programer = new Programer();

    @Override
    public Coder withIDE(IDE ide) {
        programer.setIdeForUse(ide.toString());
        return this;
    }

    @Override
    public Coder withLanguage(Language language) {
        programer.setLanguageForUse(language.toString());
        return this;
    }

    @Override
    public Coder withComputer(Computer computer) {
        programer.setPlatformForUse(computer.toString());
        return this;
    }

    @Override
    public Object code() {
        String msg = programer.printProgramer();
        return msg;
    }
}
