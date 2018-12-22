package com.example.temp.service.impl;

import com.example.temp.service.BaseService;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description
 * @ClassName BaseServiceImpl
 * @Author Liumh
 * @Date 2018/12/22 11:29
 * @Version v1.0
 */
@Slf4j
public class BaseServiceImpl implements BaseService {
    @Override
    public void testScope() {
        log.info("当前实例{}_hashCode:{}", this.getClass().getName(), this.hashCode());
    }
}
