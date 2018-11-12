package com.example.pattern;

/**
 * @Description
 * @ClassName Father
 * @Author Liumh
 * @Date 2018/11/12 13:31
 * @Version v1.0
 */
public class Father extends Handler {

    public Father() {
        super(Handler.FATHER_LEVEL_REQUEST);
    }

    @Override
    public void response(IWomen women) {
        System.out.println("======女儿向父亲请示=====");
        women.getRequest();
        System.out.println("======父亲同意了女儿的请求=====");
    }

}
