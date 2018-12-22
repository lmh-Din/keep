package com.example.basic.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Description
 * @ClassName ComparableTest
 * @Author Liumh
 * @Date 2018/12/17 16:33
 * @Version v1.0
 */
public class ComparatorTest {

    public static void main(){
        List<Integer> list = new ArrayList<>();
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
    }
}
