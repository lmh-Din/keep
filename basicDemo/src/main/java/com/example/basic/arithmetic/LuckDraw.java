package com.example.basic.arithmetic;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 幸运大转盘抽奖
 * @ClassName LuckDraw
 * @Author Liumh
 * @Date 2019/1/15 9:43
 * @Version v1.0
 */
public class LuckDraw {


    public static void main(String[] args){
        arithmetic();
        /*List<Prize> list = new ArrayList<>();
        list.add(new Prize("现金红包0.1", 0.32086));
        list.add(new Prize("现金红包0.28", 0.12834));
        list.add(new Prize("现金红包0.68", 0.06417));
        list.add(new Prize("现金红包0.88", 0.03209));
        list.add(new Prize("现金红包1.28", 0.0));
        list.add(new Prize("现金红包2.88", 0.01925));
        list.add(new Prize("现金红包3.68", 0.01283));
        list.add(new Prize("现金红包6.66", 0.00642));
        list.add(new Prize("现金红包8.88", 0.00321));
        list.add(new Prize("双肩包", 0.00321));
        list.add(new Prize("谢谢参与", 0.39679));
//        randomTest();
        try {
            int count = 0;
            for (int i=0; i<100; i++){
                int index = getPrizeIndex(list);
                if (list.get(index).getPrizename().equals("谢谢参与")){
                    count++;
                }
                System.out.println(list.get(index).toString());
            }
            System.out.println("谢谢参与："+count);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }

    private static void arithmetic(){
        int amt = 2888;
        System.out.println(Double.parseDouble(Integer.toString(amt))/100);
    }

    public static int getPrizeIndex(List<Prize> prizes) throws Exception {
            int random = -1;
        //计算总权重
        double sumWeight = 0;
        for (Prize p : prizes) {
            sumWeight += p.getRate();
        }

        //产生随机数
        double randomNumber;
        randomNumber = Math.random();
        //根据随机数在所有奖品分布的区域并确定所抽奖品
        double d1 = 0;
        double d2 = 0;
        for (int i = 0; i < prizes.size(); i++) {
            d2 += Double.parseDouble(String.valueOf(prizes.get(i).getRate())) / sumWeight;
            if (i == 0) {
                d1 = 0;
            } else {
                d1 += Double.parseDouble(String.valueOf(prizes.get(i - 1).getRate())) / sumWeight;
            }
            if (randomNumber > d1 && randomNumber <= d2) {
                random = i;
                break;
            }
        }
        return random;
    }

    private static void randomTest(){
        for (int i=0; i<10000; i++){
            System.out.println(Math.random());
        }
    }
}
