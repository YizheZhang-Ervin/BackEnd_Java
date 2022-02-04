package com.ervin.EZSpring.Utils.LibUtils.SpringUtils;

import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

public class ReflectionTools {
    static void getReflectionAPI(){
        // 获取本类及所有父类的属性
        ReflectionUtils.doWithFields(ChildA.class, new ReflectionUtils.FieldCallback() {
            @Override
            public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
                System.out.println(field.getName());
            }
        });
        // 获取本类及所有父类的所有方法
        ReflectionUtils.doWithMethods(ChildA.class, method ->
                System.out.println(method.getDeclaringClass().getName()+""+method.getName())
        );
        // 获取所有类的方法
        // Method[] allDeclaredMethods = ReflectionUtils.getAllDeclaredMethods(ChildA.class);
        // 获取某个属性的值
        ChildA xyz = new ChildA();
        xyz.setId(1L);
        ReflectionUtils.doWithFields(ChildA.class, field -> {
            field.setAccessible(true);
            Object fieldValue = ReflectionUtils.getField(field,xyz);
            System.out.println(fieldValue);
        });
    }
}

class ParentA{
    private Long id;
    public void setId(Long id){
        this.id = id;
    }
    public Long getId(){
        return this.id;
    }
}

class ChildA extends ParentA{
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}