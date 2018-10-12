package com.example.mediator.pattern.base;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description 库存
 * @ClassName Stock
 * @Author Liumh
 * @Date 2018/10/8 11:04
 * @Version v1.0
 */
@Slf4j
public class Stock {

    private static int COMPUTER_NUMBER =  100;

    //库存增加
    public void increase(int number){
        COMPUTER_NUMBER = COMPUTER_NUMBER + number;
        log.info("库存电脑数量{}台", COMPUTER_NUMBER);
    }
    //库存减少
    public void decrease(int number){
        COMPUTER_NUMBER = COMPUTER_NUMBER - number;
        log.info("库存电脑数量{}台", COMPUTER_NUMBER);
    }

    //获取库存电脑数量
    public int getStockNumber(){
        return COMPUTER_NUMBER;
    }

    //清理库存
    public void clearStock(){
        Purchase purchase = new Purchase();
        Saler saler = new Saler();
        log.info("清理库存电脑数量{}台", COMPUTER_NUMBER);
        //销售折价销售
        saler.offSale();
        //采购终止采购
        purchase.refuseBuyComputer();
    }
}
