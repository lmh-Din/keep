package com.example.controller;

import com.example.service.PrototypeService;
import com.example.service.SingletonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description
 * @ClassName TestController
 * @Author Liumh
 * @Date 2018/12/22 10:47
 * @Version v1.0
 */

@Slf4j
@Controller
@RequestMapping("/")
public class TestController {

    @Autowired
    @Qualifier("singletonService")
    private SingletonService singletonService;

    @Autowired
    @Qualifier("prototypeService")
    private PrototypeService prototypeService;

    @RequestMapping(value = "/singleton",method = RequestMethod.GET)
    @ResponseBody
    public String testScope(){
        singletonService.testScope();
        return "success";
    }

    @RequestMapping(value = "/prototype",method = RequestMethod.GET)
    @ResponseBody
    public String testPrototype(){
        prototypeService.testScope();
        return "success";
    }
}
