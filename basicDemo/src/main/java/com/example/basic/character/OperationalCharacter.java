package com.example.basic.character;

/**
 * @Description 运算符测试
 * @ClassName OperationalCharacter
 * @Author Liumh
 * @Date 2018/12/19 9:40
 * @Version v1.0
 */
public class OperationalCharacter {

    private static int num = -25;

    public static void main(String[] args){
        code();
        System.out.println("-----------------------------");
        shifting();
        System.out.println("-----------------------------");
        hashVersionCompare();
    }

    /**
     * 位移运算符测试
     *  >> 右移运算
     *  << 左移运算
     *  >>> 无符号右移运算
     */
    private static void shifting(){
        int rightShifting = num >> 2;   //右移2位
        int leftShifting = num << 2;    //左移2位
        int rightShiftingNotCharater = num >>> 2;   //无符号右移2位

        System.out.println("25:"+Integer.toBinaryString(25));
        System.out.println(num+":"+Integer.toBinaryString(num));
        System.out.println(">> result: "+rightShifting+":"+Integer.toBinaryString(rightShifting));
        System.out.println("<< result: "+leftShifting+":"+Integer.toBinaryString(leftShifting));
        System.out.println(">>> result: "+rightShiftingNotCharater+":"+Integer.toBinaryString(rightShiftingNotCharater));

    }

    /**
     * 原码
     * 反码
     * 补码
     */
    private static void code(){
        System.out.println(Integer.toBinaryString(-127));
        System.out.println(Integer.toBinaryString(127));
    }

    /**
     * hash算法 1.7 VS 1.8
     * 使用hash计算key的位置是为了减少碰撞
     */
    private static void hashVersionCompare(){

        Object key = "a";
        System.out.println(hash7(key));
        System.out.println(hash8(key));

    }

    private static int hash8(Object key){
        int h;
        // key.hashCode()：返回散列值也就是hashcode
        // ^ ：按位异或
        // >>>:无符号右移，忽略符号位，空位都以0补齐
        System.out.println("key.hashCode:"+key.hashCode());
        System.out.println("key.hashCode>>>:"+ (key.hashCode() >>> 16));
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    private static int hash7(Object k){
        int h = 0;
        h ^= k.hashCode();
        // This function ensures that hashCodes that differ only by
        // constant multiples at each bit position have a bounded
        // number of collisions (approximately 8 at default load factor).

        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }
}
