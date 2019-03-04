package com.example.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * @Description
 * @ClassName ParamterRequestWrapper
 * @Author Liumh
 * @Date 2018/11/14 17:09
 * @Version v1.0
 */
public class ParamterRequestWrapper extends HttpServletRequestWrapper {

    public ParamterRequestWrapper(HttpServletRequest request) {
        super(request);
    }
}
