package com.example.basic.compare;

import lombok.Data;

import java.util.*;

/**
 * @Description
 * @ClassName ComparableTest
 * @Author Liumh
 * @Date 2018/12/17 16:36
 * @Version v1.0
 */
public class ComparableTest {

    public static void main(String[] args){
        TreeMap<ComparableVO, String> treeMap = new TreeMap<>();
        treeMap.put(new ComparableVO("second", 2), "second");
        treeMap.put(new ComparableVO("first", 1), "first");
        Set<ComparableVO> set = treeMap.keySet();
        for (ComparableVO vo:set) {
            System.out.println(vo.toString());
        }

        testListSort();
    }

    private static void testListSort(){
        List<ComparableVO> list = new ArrayList<>();
        list.add(new ComparableVO("second", 2));
        list.add(new ComparableVO("first", 1));
        Collections.sort(list, ComparableVO::compareTo);

        for (ComparableVO vo:list) {
            System.out.println(vo.toString());
        }
    }

}

@Data
class ComparableVO implements Comparable<ComparableVO>{

    private String name;
    private int sortNum;

    public ComparableVO(String name, int sortNum) {
        this.name = name;
        this.sortNum = sortNum;
    }

    @Override
    public int compareTo(ComparableVO o) {
        if (this.sortNum > o.getSortNum()){
            return 1;
        }else if (this.sortNum < o.getSortNum()){
            return -1;
        }
        return sortNum;
    }
}
