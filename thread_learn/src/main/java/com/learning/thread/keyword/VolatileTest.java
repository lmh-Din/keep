package com.learning.thread.keyword;

/**
 * @Description
 * @ClassName VolatileTest
 * @Author Liumh
 * @Date 2018/12/5 9:52
 * @Version v1.0
 */
public class VolatileTest {

    public static void main(String[] args) throws Exception{
        VolatileThread thread = new VolatileThread();
        thread.start();
        Thread.sleep(1000);
        thread.setRunning(false);
    }

}


class VolatileThread extends Thread{

    /*
        volatile 修饰的成员变量在每次被线程访问时，
        都强迫从主存（共享内存）中重读该成员变量的值。
        而且，当成员变量发生变化时，强迫线程将变化值回写到主存（共享内存）。
        这样在任何时刻，两个不同的线程总是看到某个成员变量的同一个值，
        这样也就保证了同步数据的可见性

        不加Volatile修饰，变量被修改只是寄存器中的变量值被修改，没有写入到主存中
     */
    private boolean isRunning = true;

    private int m;

    @Override
    public void run() {
        super.run();
        System.out.println("method running");
        while (isRunning){
            int a = 2;
            int b = 3;
            int c = a+b;
            m = c;
            /*
                JVM会尽力保证内存的可见性，即便这个变量没有加同步关键字
                只要CPU有时间，JVM会尽力去保证变量值的更新(Thread.sleep()方法保证了CPU有空闲时间，因此JVM会去检查变量是否产生变化)

                这种与volatile关键字的不同在于，volatile关键字会强制的保证线程的可见性。
                而不加这个关键字，JVM也会尽力去保证可见性，
                但是如果CPU一直有其他的事情在处理，它也没办法。最开始的代码，
                一直处于死循环中，CPU处于一直占用的状态，这个时候CPU没有时间，
                JVM也不能强制要求CPU分点时间去取最新的变量值。
                而加了输出或者sleep语句之后，CPU就有可能有时间去保证内存的可见性，
                于是while循环可以被终止
             */
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("m = "+m);
        System.out.println("method is stopped");
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }
}
