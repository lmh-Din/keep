package com.example.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description
 * @ClassName ComparatorTest
 * @Author Liumh
 * @Date 2018/12/18 14:54
 * @Version v1.0
 */
public class ComparateTest {

    public static void main(String[] args){
        testComparator1();
        testComparator2();
    }

    /**
     * 包装类Comparator测试
     */
    private static void testComparator1(){
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(2);
        list.add(3);
        list.add(1);

        //完整写法
        /*Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });*/

        //精简写法
        Collections.sort(list, Integer::compareTo);

        for (Integer num:list) {
            System.out.println(num);
        }
    }

    /**
     * 自定义对象Comparator测试
     * 自定义对象需要重写CompareTo方法
     */
    private static void testComparator2(){
        List<Person> list = new ArrayList<>();
        list.add(new Person("zhangsan", 2));
        list.add(new Person("lisi", 4));
        list.add(new Person("wangwu", 0));

        //完整写法
        /*Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.compareTo(o2);
            }
        });*/

        Collections.sort(list, Person::compareTo);

        for (Person person:list) {
            System.out.println(person.toString());
        }
    }
}
