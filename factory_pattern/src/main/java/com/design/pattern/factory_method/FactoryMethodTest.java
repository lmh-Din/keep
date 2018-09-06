package com.design.pattern.factory_method;

import com.design.pattern.factory_method.entity.Car;
import com.design.pattern.factory_method.factory.CarFactoryManager;
import com.design.pattern.factory_method.factory.EngineCarFactory;

/**
 * @Description 工厂方法模式测试
 * @ClassName FactoryMethodTest
 * @Author Liumh
 * @Date 2018/9/5 16:57
 * @Version v1.0
 */
public class FactoryMethodTest {

    public static void main(String[] args){
        CarFactoryManager carFactoryManager = new EngineCarFactory();
        Car car = carFactoryManager.generateCar("Benz");
        car.carMsg();
    }
}
