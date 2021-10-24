package com.ervin.EZSpring.BasicUtils.CoreUtils;

public class OtherUtils {
    static String getRecordAPI(){
        return
            """
                不变类，除了用final修饰class以及每个字段外，编译器还自动为我们创建了构造方法，和字段名同名的方法
                以及覆写toString()、equals()和hashCode()方法
            """;
    }

    static String getJavaBeanAPI(){
        return
            """
                Introspector.getBeanInfo(Person.class).getPropertyDescriptors()
            """;
    }
}
