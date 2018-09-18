package com.temp.pattern;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description TODO
 * @ClassName CarModel
 * @Author Liumh
 * @Date 2018/9/18 14:22
 * @Version v1.0
 */
@Slf4j
public abstract class CarModel {
    public CarModel(String carName) {
        this.carName = carName;
    }

    public CarModel() {
    }

    private String carName = "";

    public void start(){
        log.info("汽车启动:{}", carName);
    }

    protected abstract void run();

    public void setCarName(String carName){
        this.carName = carName;
    }

}
