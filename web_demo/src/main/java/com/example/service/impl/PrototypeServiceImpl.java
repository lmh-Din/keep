package com.example.service.impl;

import com.example.service.PrototypeService;
import com.example.temp.service.impl.BaseServiceImpl;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @Description 每次请求都会创建一个新的 bean 实例
 *  注解无法实现
 * @ClassName PrototypeServiceImpl
 * @Author Liumh
 * @Date 2018/12/22 11:25
 * @Version v1.0
 */
@Service("prototypeService")
@Scope("prototype") //注解无效，依旧是默认的singleton
public class PrototypeServiceImpl extends BaseServiceImpl implements PrototypeService {


}
