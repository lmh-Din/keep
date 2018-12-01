package com.example.counter.util;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @ClassName FilterProcessManager
 * @Author Liumh
 * @Date 2018/11/12 15:38
 * @Version v1.0
 */
public class FilterProcessManager {

    @Autowired
    private TotalWords totalWords;

    private List<FilterProcess> list = new ArrayList<>();

    public FilterProcessManager start(){
        this.addProcess(new HttpFilterProcess())
                .addProcess(new WrapFilterProcess());
        return this;
    }

    public FilterProcessManager addProcess(FilterProcess process){
        this.list.add(process);
        return this;
    }

    public void process(String text){
        for (FilterProcess filterprocess:list) {
            text = filterprocess.process(text);
        }
        totalWords.sum(text.toCharArray().length);
    }
}
