package com.ervin.EZSpring.Utils.LibUtils.SpringUtils;

import org.springframework.beans.BeanUtils;

public class BeanTools {
    static void getBeanAPI(){
        ChildB xyz = new ChildB();
        xyz.setId(2L);
        xyz.setName("abc");
        ChildB target = new ChildB();
        // 对象拷贝
        BeanUtils.copyProperties(xyz,target);
        System.out.println(target);
    }
}

class ParentB{
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

class ChildB extends ParentB{
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