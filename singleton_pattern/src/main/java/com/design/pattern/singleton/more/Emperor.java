package com.design.principle.srp.more;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

/**
 * @Description 创建特定数量实例
 * @ClassName Emperor
 * @Author Liumh
 * @Date 2018/9/11 20:27
 * @Version v1.0
 */
public class Emperor {

    private static final int maxInstanceNum = 2;

    //线程安全
    private static Vector<Emperor> vector = new Vector<Emperor>();
    //线程不安全
    private static List<Emperor> list = new ArrayList<Emperor>();

    static {
        for (int instanceNum = 0; instanceNum < maxInstanceNum; instanceNum++){
            Emperor emperor = new Emperor();
            list.add(emperor);
        }
    }

    /**
     * 私有化构造方法，不能通过new创建实例
     */
    private Emperor() {
    }

    public static Emperor getInstance(){
        Random random = new Random();
        Emperor instance = list.get(random.nextInt(maxInstanceNum));
        return instance;
    }
}
