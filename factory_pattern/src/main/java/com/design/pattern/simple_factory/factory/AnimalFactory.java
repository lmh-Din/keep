package com.design.pattern.simple_factory.factory;

import com.design.pattern.simple_factory.entity.Animal;
import com.design.pattern.simple_factory.entity.Cat;
import com.design.pattern.simple_factory.entity.Dog;

/**
 * @Description 工厂类
 * @ClassName AnimalFactory
 * @Author Liumh
 * @Date 2018/9/5 13:35
 * @Version v1.0
 */
public class AnimalFactory {

    public static Animal generateAnimal(String animalType){
        Animal animal = null;
        switch (animalType){
            case "cat":
                animal = new Cat();
                break;
            case "dog":
                animal = new Dog();
                break;
            default:
                animal = null;
        }
        return animal;
    }
}
