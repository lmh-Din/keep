package com.example.pattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Description
 * @ClassName Client
 * @Author Liumh
 * @Date 2018/11/12 13:38
 * @Version v1.0
 */
public class Client {

    public static void main(String[] args){
        Random random = new Random();
        List<IWomen> list = new ArrayList<>();
        for (int i=0;i<4;i++){
            list.add(new Women(i, "逛街"));
        }
        Handler father = new Father();
        Handler husband = new Husband();
        Handler son = new Son();
        father.setNext(husband);
        husband.setNext(son);
        for (IWomen women:list) {
            System.out.println(women.getType());
            father.handleMessage(women);
        }

    }
}
