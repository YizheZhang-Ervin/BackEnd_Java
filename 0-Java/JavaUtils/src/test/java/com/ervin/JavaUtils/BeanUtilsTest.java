package com.ervin.JavaUtils;

import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;

public class BeanUtilsTest {
    @Test
    public void test1(){
        XYZ2 xyz = new XYZ2();
        xyz.setId(2L);
        xyz.setName("abc");
        XYZ2 target = new XYZ2();
        // 对象拷贝
        BeanUtils.copyProperties(xyz,target);
        System.out.println(target);
    }
}
class Person2{
    private Long id;
    public void setId(Long id){
        this.id = id;
    }
    public Long getId(){
        return this.id;
    }

    @Override
    public String toString() {
        return "Person2{" +
                "id=" + id +
                '}';
    }
}

class XYZ2 extends Person2{
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return super.toString()+"XYZ2{" +
                "name='" + name + '\'' +
                '}';
    }
}