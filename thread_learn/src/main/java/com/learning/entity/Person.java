package com.learning.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Liumh on 2018/8/29.
 */
@Data
public class Person {

    private String name;

    private String sex;

    private Integer age;

    private List<String> list = new ArrayList<String>();

    public synchronized List<String> getSource(){
        return list;
    }

    public synchronized void setSource(String id){
        list.add(id);
    }
}
