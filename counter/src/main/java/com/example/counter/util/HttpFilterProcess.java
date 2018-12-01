package com.example.counter.util;

/**
 * @Description
 * @ClassName HttpFilterProcess
 * @Author Liumh
 * @Date 2018/11/12 15:34
 * @Version v1.0
 */
public class HttpFilterProcess implements FilterProcess {

    /**
     * 超链接处理
     * @param text
     * @return
     */
    @Override
    public String process(String text) {
        text = text.replaceAll("^((https|http|ftp|rtsp|mms)?:\\\\/\\\\/)[^\\\\s]+", "");
        return text;
    }
}
