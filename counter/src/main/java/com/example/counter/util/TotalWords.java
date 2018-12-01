package com.example.counter.util;

import org.springframework.stereotype.Component;

/**
 * @Description
 * @ClassName TotalWords
 * @Author Liumh
 * @Date 2018/11/13 13:36
 * @Version v1.0
 */
@Component
public class TotalWords {

    private int countWords = 0;

    public void sum(int length) {
        countWords+=length;
    }

}
