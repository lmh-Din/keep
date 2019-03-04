package com.example.basic.math;

import java.math.BigDecimal;
import java.util.Random;

/**
 * @Description
 * @ClassName MathTest
 * @Author Liumh
 * @Date 2019/1/15 16:03
 * @Version v1.0
 */
public class MathTest {

    public static void main(String[] args){
        double d = Double.parseDouble("1.888");
        BigDecimal bigDecimal = new BigDecimal(d*100);
        Random random = new Random();
        for (int i=0; i<10; i++){
            System.out.println(random.nextInt(2)+1);
        }
//        System.out.println(bigDecimal.intValue());
    }
}
