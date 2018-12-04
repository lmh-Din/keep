package com.learning.thread.pkt;

/**
 * @Description 脏读测试
 * @ClassName DirtyRead
 * @Author Liumh
 * @Date 2018/12/3 10:23
 * @Version v1.0
 */
public class DirtyReadTest {

    public static void main(String[] args){
        try {
            DirtyEntity dirtyEntity = new DirtyEntity();
            DirtyThreadA threadA = new DirtyThreadA(dirtyEntity);
            threadA.start();
            //打印结果受睡眠时长影响
            threadA.sleep(300);
            dirtyEntity.getValue();
        }catch (Exception e){

        }
    }

}

class DirtyEntity{
    public String userName;
    public String passWord;

    public synchronized void setValue(String userName, String passWord){
        try {
            this.userName=userName;
            Thread.sleep(3000);
            this.passWord=passWord;
            System.out.println("setVal method name = " + Thread.currentThread().getName()
                    + " userName="+userName+" passWord="+passWord);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //synchronized是获取当前对象的锁，
    // setvalue占用锁，getvalue等待锁的释放。可以达到同步的效果
    public synchronized void getValue(){
        System.out.println("getValue method thread name="
                + Thread.currentThread().getName() + " username=" + userName
                + " password=" + passWord);
    }
}

class DirtyThreadA extends Thread{

    private DirtyEntity dirtyEntity;

    public DirtyThreadA(DirtyEntity dirtyEntity) {
        super();
        this.dirtyEntity=dirtyEntity;
    }

    @Override
    public void run() {
        super.run();
        dirtyEntity.setValue("A", "AA");
    }

}
