package com.design.pattern.factory_method.factory;

import com.design.pattern.factory_method.entity.Benz;
import com.design.pattern.factory_method.entity.Car;
import com.design.pattern.factory_method.entity.Honda;
import com.design.pattern.factory_method.entity.LinkCo;

/**
 * @Description 机动车工厂
 * @ClassName CarFactory
 * @Author Liumh
 * @Date 2018/9/5 15:19
 * @Version v1.0
 */
public class EngineCarFactory implements CarFactoryManager {

    @Override
    public Car generateCar(String trademark) {
        Car car = null;
        switch (trademark){
            case "Benz":
                car = new Benz();
                break;
            case "Honda":
                car = new Honda();
                break;
            case "Linkco":
                car = new LinkCo();
                break;
            default:
                car = null;
        }
        return car;
    }
}
