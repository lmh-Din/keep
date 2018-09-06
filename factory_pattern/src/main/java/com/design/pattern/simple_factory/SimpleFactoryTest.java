package com.design.pattern.simple_factory;

import com.design.pattern.simple_factory.entity.Animal;
import com.design.pattern.simple_factory.factory.AnimalFactory;

/**
 * @Description TODO
 * @ClassName SimpleFactoryTest
 * @Author Liumh
 * @Date 2018/9/5 13:52
 * @Version v1.0
 */
public class SimpleFactoryTest {

    public static void main(String[] args){
        Animal animal = AnimalFactory.generateAnimal("cat");
        String descMsg = animal.animalDesc();
        System.out.println(descMsg);
    }
}
