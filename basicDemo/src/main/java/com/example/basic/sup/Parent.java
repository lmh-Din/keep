package com.example.basic.sup;

/**
 * @Description
 * @ClassName Parent
 * @Author Liumh
 * @Date 2019/2/14 14:21
 * @Version v1.0
 */
public class Parent{
    private String name;

    private String sex;

    static {
        System.out.println("这里是父类静态方法块");
    }

    public Parent() {
        System.out.println("这里是父类无参构造方法");
    }

    public Parent(String name, String sex) {
        System.out.println("这里是父类含参构造方法");
        this.name = name;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
