package com.design.pattern.simple_factory.entity;

/**
 * @Description 猫
 * @ClassName Cat
 * @Author Liumh
 * @Date 2018/9/5 13:40
 * @Version v1.0
 */
public class Cat implements Animal {

    @Override
    public String animalDesc() {
        StringBuffer desc = new StringBuffer("动物种类为：");
        desc.append(this.getClass().getSimpleName());
        return desc.toString();
    }
}
