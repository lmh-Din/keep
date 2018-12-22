package com.example.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @ClassName AwareConfig
 * @Author Liumh
 * @Date 2018/12/22 14:15
 * @Version v1.0
 */
@Slf4j
@Configuration
public class AwareConfig implements ApplicationContextAware {

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("Method setApplicationContext processing....");
        log.info("--------------------------");
        log.info("ApplicationName:{}", applicationContext.getApplicationName());
        log.info("--------------------------");
        log.info("BeanDefinitionNames:{}", applicationContext.getBeanDefinitionNames());
    }

}
