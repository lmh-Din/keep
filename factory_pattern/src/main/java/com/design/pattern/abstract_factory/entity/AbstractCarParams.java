package com.design.pattern.abstract_factory.entity;

import lombok.Data;

/**
 * @Description TODO
 * @ClassName AbstractCar
 * @Author Liumh
 * @Date 2018/9/6 11:24
 * @Version v1.0
 */
@Data
public abstract class AbstractCarParams {
    /**
     * 商标
     */
    public String trademark;
    /**
     * 价格
     */
    public Long price;
    /**
     * 耗油量
     */
    public String fuelConsumption;

    public AbstractCarParams(String trademark, Long price, String fuelConsumption) {
        this.trademark = trademark;
        this.price = price;
        this.fuelConsumption = fuelConsumption;
    }
}