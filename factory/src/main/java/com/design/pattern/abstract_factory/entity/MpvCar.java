package com.design.pattern.abstract_factory.entity;

import lombok.Data;

/**
 * @Description TODO
 * @ClassName MpvCar
 * @Author Liumh
 * @Date 2018/9/6 10:59
 * @Version v1.0
 */
public class MpvCar extends AbstractCarParams implements Car {

    public MpvCar(String trademark, Long price, String fuelConsumption) {
        super(trademark, price, fuelConsumption);
    }

    @Override
    public String carDesc() {
        return "MPV";
    }
}
