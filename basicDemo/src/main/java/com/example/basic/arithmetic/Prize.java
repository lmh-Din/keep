package com.example.basic.arithmetic;

import lombok.Data;

/**
 * 奖品表
 */

@Data
public class Prize {
    private Integer id;
    /**
     * 奖品名称
     */
    private String prizename;
    /**
     * 总数量
     */
    private Integer totalnum;
    /**
     * 剩余数量
     */
    private Integer leftnum;
    /**
     * 金额
     */
    private Integer amount;
    /**
     * 中奖率
     */
    private Double rate;
    /**
     * 中奖类型
     */
    private String type;
    /**
     * 版本
     */
    private String version;
    /**
     * 备用字段
     */
    private String file1;


    public Prize(String prizename, Double rate) {
        this.prizename = prizename;
        this.rate = rate;
    }
}