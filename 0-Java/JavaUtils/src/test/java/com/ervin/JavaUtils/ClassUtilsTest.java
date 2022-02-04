package com.ervin.JavaUtils;

import org.junit.jupiter.api.Test;
import org.springframework.util.ClassUtils;

public class ClassUtilsTest {
    @Test
    public void test1(){
        // 判断类是否加载
        String className = "com.ervin.testclass";
        // 方法1：Class.forName(className)
        // 方法2：ClassUtilsTest.class.getClassLoader().loadClass(className)
        System.out.println(ClassUtils.isPresent(className,null));
    }
}
