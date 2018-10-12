package com.example.mediator.pattern.base;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

/**
 * @Description 销售
 * @ClassName Saler
 * @Author Liumh
 * @Date 2018/10/8 11:01
 * @Version v1.0
 */
@Data
@Slf4j
public class Saler {


    public void sellComputer(int number){
        Stock stock = new Stock();
        Purchase purchase = new Purchase();
        if (stock.getStockNumber() < number){   //库存电脑数量不足
            purchase.buyComputer(number);
        }
        log.info("销售电脑{}台", number);
        stock.decrease(number);

    }

    //获取销售状态
    public int getSaleStatus(){
        Random rand = new Random(System.currentTimeMillis());
        int saleStatus = rand.nextInt(100);
        log.info("电脑的销售情况为：{}", saleStatus);
        return saleStatus;
    }

    //折价销售
    public void offSale() {
        //清仓大处理
        Stock stock = new Stock();
        log.info("折价销售电脑{}台", stock.getStockNumber());
    }
}
