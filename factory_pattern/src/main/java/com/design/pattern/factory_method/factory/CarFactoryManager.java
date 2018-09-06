package com.design.pattern.factory_method.factory;

import com.design.pattern.factory_method.entity.Car;

/**
 * @Description 汽车工厂接口
 * @ClassName CarFactoryManager
 * @Author Liumh
 * @Date 2018/9/5 15:16
 * @Version v1.0
 */
public interface CarFactoryManager {

    public Car generateCar(String trademark);
}
