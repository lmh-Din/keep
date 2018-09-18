package com.temp.pattern;

/**
 * @Description TODO
 * @ClassName CarClient
 * @Author Liumh
 * @Date 2018/9/18 14:44
 * @Version v1.0
 */
public class CarClient {

    public static void main(String[] args){
        CarModel benzModel = new BenzModel("奔驰");
        benzModel.run();
        CarModel BMWModel = new BMWModel("宝马");
        BMWModel.run();
        test();
    }

    private static void test() {
        try {
            BenzModel benzModel = (BenzModel)Class.forName("com.temp.pattern.BenzModel").newInstance();
            System.out.println(benzModel.getClass().getName());
            benzModel.run();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
