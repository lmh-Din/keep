package com.learning.thread.communication.threadlocal;

/**
 * @Description ThreadLocal具备线程隔离性
 * @ClassName ThreadLocalTest
 * @Author Liumh
 * @Date 2018/12/10 14:45
 * @Version v1.0
 */
public class ThreadLocalTest {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    private static ThreadExt threadExt = new ThreadExt();

    public static void main(String[] args){
        /*if (threadLocal.get() == null){
            System.out.println("ThreadLocal set value");
            threadLocal.set("testAAA");
        }
        System.out.println("Threadlocal value："+threadLocal.get());
        System.out.println("Threadlocal value："+threadLocal.get());*/

        if (threadExt.get() == null){
            System.out.println("ThreadExt set value");
            threadExt.set("AAA");
        }
        System.out.println(threadExt.get());
    }
}

class ThreadExt extends ThreadLocal<String>{

    @Override
    protected String initialValue() {
        return "Initial ThreadLocal value";
    }
}
