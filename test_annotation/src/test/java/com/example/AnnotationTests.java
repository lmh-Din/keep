package com.example;

import com.example.spring.AnnatationAsync;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @Description
 * @ClassName AnnotationTests
 * @Author Liumh
 * @Date 2018/11/1 19:34
 * @Version v1.0
 */
public class AnnotationTests extends ApplicationTests {

    @Autowired
    private AnnatationAsync annatationAsync;


    @Test
    public void test(){
        annatationAsync.noResultTest();
    }

    @Test
    public void testWithParams(){
        annatationAsync.noResultTest("a", 1, 2L);
    }

    @Test
    public void testWithParams2(){
        annatationAsync.noResultTest(new LinkedList<>(), new ArrayList<>(), new HashMap<>());
    }

    @Test
    public void test11(){
        Long l = 1024L;
        System.out.println(l/100);
    }
}
