package com.example.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description List常用操作
 * @ClassName ListOperatioin
 * @Author Liumh
 * @Date 2018/12/18 15:34
 * @Version v1.0
 */
public class ListOperatioin {

    private static List<String> list1 = new ArrayList<>();
    private static List<String> list2 = new ArrayList<>();

    public static void main(String[] args){

        list_arraysTransform();


    }

    /**
     * List-Arrays互转
     */
    private static void list_arraysTransform(){
        list1.add("qqq");
        list1.add("www");
        list1.add("eee");
        String[] strs = new String[list1.size()];
        //List 转 Arrays
        list1.toArray(strs);
        for (String str:strs) {
            System.out.println(str);
        }

        //Arrays 转 List
        List<String> aslist = Arrays.asList(strs);
        System.out.println(aslist);

        //List转ArrayList
        List<String>  list = new ArrayList<>();
        list.addAll(aslist);
        System.out.println(list);


//        list2.add("aaa");
//        list2.add("bbb");
//        list2.add("ccc");
//        list2.add("qqq");
    }

}
