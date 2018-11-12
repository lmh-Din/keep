package com.example.pattern;

/**
 * @Description
 * @ClassName Handler
 * @Author Liumh
 * @Date 2018/11/12 13:18
 * @Version v1.0
 */
public abstract class Handler {

    public final static int FATHER_LEVEL_REQUEST = 1;
    public final static int HUSBAND_LEVEL_REQUEST = 2;
    public final static int SON_LEVEL_REQUEST = 3;

    public Handler(int level) {
        this.level = level;
    }

    //能处理的级别
    private int level = 0;

    //责任传递，下一个责任人
    private Handler nextHandler;

    public void handleMessage(IWomen women){
        if (women.getType() == this.level){
            this.response(women);
        }else {
            if (nextHandler != null){
                this.nextHandler.handleMessage(women);
            }else {
                System.out.println("责任链无下一节点");
            }
        }
    }

    /**
     * 用于下一处理节点
     * @param handler
     */
    public void setNext(Handler handler){
        this.nextHandler = handler;
    }

    public abstract void response(IWomen women);
}
