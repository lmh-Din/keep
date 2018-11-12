package com.example.pattern;


/**
 * @Description
 * @ClassName Son
 * @Author Liumh
 * @Date 2018/11/12 13:31
 * @Version v1.0
 */
public class Son extends Handler {

    public Son() {
        super(SON_LEVEL_REQUEST);
    }

    @Override
    public void response(IWomen women) {
        System.out.println("======母亲向儿子请示=====");
        women.getRequest();
        System.out.println("======儿子同意了母亲的请求=====");
    }
}
