package com.temp.pattern;

/**
 * @Description TODO
 * @ClassName BenzModel
 * @Author Liumh
 * @Date 2018/9/18 14:27
 * @Version v1.0
 */
public class BenzModel extends CarModel {

    public BenzModel(String carName) {
        super(carName);
    }

    public BenzModel() {
    }

    @Override
    protected void run() {
        super.start();
    }

}
