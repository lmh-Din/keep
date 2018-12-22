package com.example.service.impl;

import com.example.service.SingletonService;
import com.example.temp.service.impl.BaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Description singleton
 *      Spring IOC 容器中只存在该对象的一个Bean实例，Bean以单例的形式存在  default
 * @ClassName TestServiceImpl
 * @Author Liumh
 * @Date 2018/12/22 10:41
 * @Version v1.0
 */
@Service("singletonService")
@Scope("singleton")
@Slf4j
@Lazy   //懒加载
public class SingletonServiceImpl extends BaseServiceImpl implements SingletonService {

    /*
    当一个 bean 的作用域为 singleton，那么Spring IoC容器中只会存在一个共享的 bean 实例，
    并且所有对 bean 的请求，只要 id 与该 bean 定义相匹配，则只会返回bean的同一实例

    bean的作用域默认是singleton
     */

    @PostConstruct
    public void init(){
        log.info("执行inti。。。");
    }

    @PreDestroy
    public void destroy(){
        log.info("执行destroy。。。");
    }

}
