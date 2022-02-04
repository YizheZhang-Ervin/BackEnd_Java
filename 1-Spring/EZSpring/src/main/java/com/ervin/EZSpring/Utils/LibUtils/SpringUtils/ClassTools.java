package com.ervin.EZSpring.Utils.LibUtils.SpringUtils;

import org.springframework.util.ClassUtils;

public class ClassTools {
    static void getClassAPI(){
        // 判断类是否加载
        String className = "com.ervin.EZSpring.Utils.LibUtils.SpringUtils.ClassTools";
        // 方法1：Class.forName(className)
        // 方法2：ClassTools.class.getClassLoader().loadClass(className)
        System.out.println(ClassUtils.isPresent(className,null));
    }
}
