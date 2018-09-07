package com.builder.pattern;

import com.builder.pattern.enums.Computer;
import com.builder.pattern.enums.IDE;
import com.builder.pattern.enums.Language;

/**
 * 抽象出的Coder
 * Created by Liumh on 2018/9/6.
 */
public interface Coder {

    Coder withIDE(IDE ide);
    Coder withLanguage(Language language);
    Coder withComputer(Computer computer);
    /**
     * 未使用，可以用作扩展
     * @return
     */
    Object code();

}
