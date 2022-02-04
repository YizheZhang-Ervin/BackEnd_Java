package com.ervin.part2.java8;

import org.junit.Test;

import java.lang.reflect.Method;

public class TestAnnotation {
    // 类型注解
    // 可配合checker framework使用
    // private @NonNull Object obj = null;

    @Test
    public void test1() throws NoSuchMethodException {
        Class<TestAnnotation> clazz = TestAnnotation.class;
        Method m1 = clazz.getMethod("show");
        MyAnnotation[] mas = m1.getAnnotationsByType(MyAnnotation.class);
        for(MyAnnotation myAnnotation:mas){
            System.out.println(myAnnotation.value());
        }
        TestAnnotation.show2("test");
    }

    // 重复注解
    @MyAnnotation("Hello")
    @MyAnnotation("World")
    public void show(){

    }

    // 类型注解
    public static void show2(@MyAnnotation("abc") String str){
        System.out.println(str);
    }
}
