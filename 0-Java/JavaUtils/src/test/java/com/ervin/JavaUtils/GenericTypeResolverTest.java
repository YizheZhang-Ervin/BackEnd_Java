package com.ervin.JavaUtils;

import org.junit.jupiter.api.Test;
import org.springframework.core.GenericTypeResolver;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class GenericTypeResolverTest {
    @Test
    public void test1(){
        new UserDao().insert(new Object());
        // 解析泛型类型的参数(代替BaseDao里的一堆代码)
        // Class<?> aClass = GenericTypeResolver.resolveTypeArgument(UserDao.class,BaseDao.class);
        // System.out.println(aClass.getName());
    }
}

abstract class BaseDao<T>{
    private Class<T> clazz;
    public BaseDao(){
        ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
        Type actualTypeArgument = parameterizedType.getActualTypeArguments()[0];
        clazz = (Class<T>) actualTypeArgument;
    }
    public void insert(T t){
        System.out.println(clazz.getName());
    }
}

class UserDao extends BaseDao<Object>{
    @Override
    public void insert(Object obj){
        System.out.println(obj);
    }
}