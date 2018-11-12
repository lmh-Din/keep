package com.example.pattern;

/**
 * @Description
 * @ClassName Husband
 * @Author Liumh
 * @Date 2018/11/12 13:31
 * @Version v1.0
 */
public class Husband extends Handler {

    public Husband() {
        super(HUSBAND_LEVEL_REQUEST);
    }

    @Override
    public void response(IWomen women) {
        System.out.println("======妻子向丈夫请示=====");
        women.getRequest();
        System.out.println("======丈夫同意了妻子的请求=====");
    }
}
