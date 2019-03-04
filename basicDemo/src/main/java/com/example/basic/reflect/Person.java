package com.example.basic.reflect;

import lombok.Data;

/**
 * @Description
 * @ClassName Person
 * @Author Liumh
 * @Date 2019/1/11 14:03
 * @Version v1.0
 */
@Data
public class Person {

    private String name;

    private Integer age;

    private boolean sex;

    public Person(String name, Integer age, boolean sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
}
