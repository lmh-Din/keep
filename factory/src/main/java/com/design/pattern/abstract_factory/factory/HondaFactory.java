package com.design.pattern.abstract_factory.factory;

import com.design.pattern.abstract_factory.entity.Car;
import com.design.pattern.abstract_factory.entity.MpvCar;
import com.design.pattern.abstract_factory.entity.SmallCar;
import com.design.pattern.abstract_factory.entity.SuvCar;

/**
 * @Description TODO
 * @ClassName HondaFactory
 * @Author Liumh
 * @Date 2018/9/6 10:44
 * @Version v1.0
 */
public class HondaFactory implements AbstractCarFactory {
    @Override
    public Car smallCar() {
        return new SmallCar("Honda",  100000L, "6.5L");
    }

    @Override
    public Car suvCar() {
        return new SuvCar("Honda",  200000L, "10.0L");
    }

    @Override
    public Car mpvCar() {
        return new MpvCar("Honda",  300000L, "12.0L");
    }
}
