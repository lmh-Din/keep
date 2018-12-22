package com.example.sort;

import lombok.Data;

/**
 * @Description
 * @ClassName Person
 * @Author Liumh
 * @Date 2018/12/18 14:07
 * @Version v1.0
 */
@Data
public class Person implements Comparable<Person> {

    private String name;
    private Integer age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person o) {
        if (this.age > o.getAge()){
            return 1;
        }else if (this.age < o.getAge()){
            return -1;
        }
        return 0;
    }
}
