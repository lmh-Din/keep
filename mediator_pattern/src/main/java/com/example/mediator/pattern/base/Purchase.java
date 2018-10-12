package com.example.mediator.pattern.base;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description 采购
 * @ClassName Purchase
 * @Author Liumh
 * @Date 2018/10/8 10:59
 * @Version v1.0
 */
@Slf4j
public class Purchase {

    //购买电脑
    public void buyComputer(int number){
        //访问库存
        Stock stock = new Stock();
        //销售
        Saler saler = new Saler();
        //电脑销售状态
        int saleStatus = saler.getSaleStatus();

        if (saleStatus > 80){//如果销售状态良好
            log.info("采购电脑{}台", number);
            stock.increase(number);
        }else {//销售状态不好
            log.info("采购电脑{}台", number/2);
            stock.increase(number/2);
        }
    }

    //不再购买电脑
    public void refuseBuyComputer(){
        log.info("不再购买电脑");
    }

}
