package com.ervin.EZSpring.Utils.LibUtils.SpringUtils;

import org.springframework.core.GenericTypeResolver;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class GenericTypeResolverTools {
    static void getGenericTypeResolverAPI(){
        new UserDaoA().insert(new Object());
        // 解析泛型类型的参数(代替BaseDao里的一堆代码)
         Class<?> aClass = GenericTypeResolver.resolveTypeArgument(UserDaoA.class,BaseDaoA.class);
         System.out.println(aClass.getName());
    }
}

abstract class BaseDaoA<T>{
    private Class<T> clazz;
    public BaseDaoA(){
        ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
        Type actualTypeArgument = parameterizedType.getActualTypeArguments()[0];
        clazz = (Class<T>) actualTypeArgument;
    }
    public void insert(T t){
        System.out.println(clazz.getName());
    }
}

class UserDaoA extends BaseDaoA<Object>{
    @Override
    public void insert(Object obj){
        System.out.println(obj);
    }
}