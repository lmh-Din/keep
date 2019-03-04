package com.example.basic.reflect;

import lombok.extern.slf4j.Slf4j;
import lombok.val;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @ClassName BeanToMap
 * @Author Liumh
 * @Date 2019/1/11 14:03
 * @Version v1.0
 */
@Slf4j
public class BeanToMap {

    public static void main(String[] args){
        Person person = new Person("lmh", 24, true);
        Map<String, String> map = new HashMap<>();
        try {
            beanToMap(person, map);
            log.info("source:{}", person);
            log.info("target:{}", map);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void beanToMap(Object source, Map<String, String> target) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class cls = source.getClass();
        Field[] fields = cls.getDeclaredFields();
        for (Field field:fields) {
            String fieldName = field.getName();
            String fieldTypeName = field.getType().getName();
            log.info("FieldName:{},FiledType:{}", fieldName, fieldTypeName);
            StringBuffer methodName = new StringBuffer();
            if ("boolean".equals(fieldTypeName)){
                methodName.append("is");
            }else {
                methodName.append("get");
            }
            Method method = cls.getMethod(methodName.append(upperCaseFirstLetter(fieldName)).toString());
            Object fieldVal = method.invoke(source);
            target.put(fieldName, fieldVal.toString());
        }
    }

    /**
     * 首字母大写
     * @param letter
     */
    private static String upperCaseFirstLetter(String letter){
        StringBuffer str = new StringBuffer();
        String upperCaseLetter = letter.substring(0, 1).toUpperCase();
        str.append(upperCaseLetter).append(letter.substring(1));
        return str.toString();
    }
}
