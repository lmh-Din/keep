package com.builder.pattern;

import com.builder.pattern.enums.Computer;
import com.builder.pattern.enums.IDE;
import com.builder.pattern.enums.Language;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description 编码所需工具
 * @ClassName CodingWith
 * @Author Liumh
 * @Date 2018/9/7 9:48
 * @Version v1.0
 */
@Data
@Slf4j
public abstract class CodingWith {
    public IDE ide;
    public Language language;
    public Computer computer;
}
