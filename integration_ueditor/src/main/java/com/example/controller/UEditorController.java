package com.example.controller;

import com.baidu.ueditor.ActionEnter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

/**
 * @Description
 * @ClassName UEditorController
 * @Author Liumh
 * @Date 2018/11/14 10:13
 * @Version v1.0
 */
@RequestMapping("/")
@Controller
@Slf4j
public class UEditorController {

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/config")
    public void config(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("application/json");
        String rootPath = request.getSession().getServletContext().getRealPath("/");
        try {
            String exec = new ActionEnter(request, rootPath).exec();
            PrintWriter writer = response.getWriter();
            writer.write(exec);
            writer.flush();
            writer.close();
        }catch (Exception e){
            log.error("");
        }
    }

    @RequestMapping("/para")
    public void config(String params){
        log.info("params:[{}]", params.toString());
    }
}
