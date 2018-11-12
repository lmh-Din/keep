package com.example.pattern;

/**
 * @Description
 * @ClassName Women
 * @Author Liumh
 * @Date 2018/11/12 13:38
 * @Version v1.0
 */
public class Women implements IWomen {

    /**
     * 1：未出嫁
     * 2：出嫁
     * 3：丧偶
     */
    private int type = 0;

    /**
     * 请求
     */
    private String request;

    public Women(int type, String request) {
        this.type = type;
        this.request = request;
    }

    @Override
    public int getType() {
        return this.type;
    }

    @Override
    public String getRequest() {
        return this.request;
    }
}
