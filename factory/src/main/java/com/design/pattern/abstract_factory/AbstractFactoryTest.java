package com.design.pattern.abstract_factory;

import com.design.pattern.abstract_factory.entity.Car;
import com.design.pattern.abstract_factory.factory.AbstractCarFactory;
import com.design.pattern.abstract_factory.factory.BenzFactory;
import com.design.pattern.abstract_factory.factory.HondaFactory;

/**
 * @Description TODO
 * @ClassName AbstractFactoryTest
 * @Author Liumh
 * @Date 2018/9/6 11:16
 * @Version v1.0
 */
public class AbstractFactoryTest {

    public static void main(String[] args){
        //生产Honda品牌的各种型号车辆实例
//        AbstractCarFactory carFactory = new HondaFactory();
        //生产Benz品牌下的各种型号车辆实例
        AbstractCarFactory carFactory = new BenzFactory();
        Car smallCar = carFactory.smallCar();
        Car suvCar = carFactory.suvCar();
        Car mpvCar = carFactory.mpvCar();
        System.out.println(smallCar.toString());
        System.out.println(suvCar.toString());
        System.out.println(mpvCar.toString());

    }
}
