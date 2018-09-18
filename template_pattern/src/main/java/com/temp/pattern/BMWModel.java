package com.temp.pattern;

/**
 * @Description TODO
 * @ClassName BMWModel
 * @Author Liumh
 * @Date 2018/9/18 14:43
 * @Version v1.0
 */
public class BMWModel extends CarModel {

    public BMWModel(String carName) {
        super(carName);
    }

    @Override
    protected void run() {
        super.start();
    }
}
