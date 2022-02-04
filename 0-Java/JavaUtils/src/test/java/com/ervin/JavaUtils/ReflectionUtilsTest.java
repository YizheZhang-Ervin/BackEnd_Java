package com.ervin.JavaUtils;

import org.junit.jupiter.api.Test;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionUtilsTest {
    @Test
    public void test1(){
        // 获取本类及所有父类的属性
        ReflectionUtils.doWithFields(XYZ.class, new ReflectionUtils.FieldCallback() {
            @Override
            public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
                System.out.println(field.getName());
            }
        });
        // 获取本类及所有父类的所有方法
        ReflectionUtils.doWithMethods(XYZ.class,method ->
                System.out.println(method.getDeclaringClass().getName()+""+method.getName())
        );
        // 获取所有类的方法
        // Method[] allDeclaredMethods = ReflectionUtils.getAllDeclaredMethods(XYZ.class);
        // 获取某个属性的值
        XYZ xyz = new XYZ();
        xyz.setId(1L);
        ReflectionUtils.doWithFields(XYZ.class, field -> {
            field.setAccessible(true);
            Object fieldValue = ReflectionUtils.getField(field,xyz);
            System.out.println(fieldValue);
        });

    }
}

class Person{
    private Long id;
    public void setId(Long id){
        this.id = id;
    }
    public Long getId(){
        return this.id;
    }
}

class XYZ extends Person{
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}