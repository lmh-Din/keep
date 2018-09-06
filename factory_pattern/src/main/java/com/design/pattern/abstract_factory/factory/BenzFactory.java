package com.design.pattern.abstract_factory.factory;

import com.design.pattern.abstract_factory.entity.Car;
import com.design.pattern.abstract_factory.entity.MpvCar;
import com.design.pattern.abstract_factory.entity.SmallCar;
import com.design.pattern.abstract_factory.entity.SuvCar;

/**
 * @Description TODO
 * @ClassName BenzFactory
 * @Author Liumh
 * @Date 2018/9/6 11:14
 * @Version v1.0
 */
public class BenzFactory implements AbstractCarFactory {
    @Override
    public Car smallCar() {
        return new SmallCar("Benz", 300000L, "8.0L");
    }

    @Override
    public Car suvCar() {
        return new SuvCar("Benz", 500000L, "12.0L");
    }

    @Override
    public Car mpvCar() {
        return new MpvCar("Benz", 800000L, "15.0L");
    }
}
