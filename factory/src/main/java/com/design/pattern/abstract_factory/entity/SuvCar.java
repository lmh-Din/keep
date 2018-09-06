package com.design.pattern.abstract_factory.entity;

import lombok.Data;

/**
 * @Description TODO
 * @ClassName SuvCar
 * @Author Liumh
 * @Date 2018/9/6 10:58
 * @Version v1.0
 */
public class SuvCar extends AbstractCarParams implements Car {


    public SuvCar(String trademark, Long price, String fuelConsumption) {
        super(trademark, price, fuelConsumption);
    }

    @Override
    public String carDesc() {
        return "SUV";
    }
}
