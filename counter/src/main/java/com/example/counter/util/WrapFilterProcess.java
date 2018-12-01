package com.example.counter.util;

/**
 * @Description
 * @ClassName WrapFilterProcess
 * @Author Liumh
 * @Date 2018/11/12 15:20
 * @Version v1.0
 */
public class WrapFilterProcess implements FilterProcess {

    /**
     * 换行和空格处理
     * @param text
     * @return
     */
    @Override
    public String process(String text) {
        text = text.replaceAll("\\s", "");
        return text;
    }

}
