package com.design.pattern.abstract_factory.factory;

import com.design.pattern.abstract_factory.entity.Car;

/**
 * 抽象汽车工厂
 * Created by Liumh on 2018/9/6.
 */
public interface AbstractCarFactory {

    Car smallCar();

    Car suvCar();

    Car mpvCar();
}
