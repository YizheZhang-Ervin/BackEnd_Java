package com.ervin;

public class Reflection {
    public static void main(String[] args) throws ClassNotFoundException {
        // 方法1：获取类
        Class<String> cls = String.class;
        // 方法2：获取类
        String s = "Hello";
        Class<? extends String> cls2 = s.getClass();
        // 方法3：获取类
        Class<?> cls3 = Class.forName("java.lang.String");

        // 1、访问字段
        // Field getField(name)：根据字段名获取某个public的field（包括父类）
        // Field getDeclaredField(name)：根据字段名获取当前类的某个field（不包括父类）
        // Field[] getFields()：获取所有public的field（包括父类）
        // Field[] getDeclaredFields()：获取当前类的所有field（不包括父类）
        // Field中所有信息
        // getName()：返回字段名称，例如，"name"；
        // getType()：返回字段类型，也是一个Class实例，例如，String.class；
        // getModifiers()：返回字段的修饰符，它是一个int，不同的bit表示不同的含义。

        // 2、调用方法
        // Method getMethod(name, Class...)：获取某个public的Method（包括父类）
        // Method getDeclaredMethod(name, Class...)：获取当前类的某个Method（不包括父类）
        // Method[] getMethods()：获取所有public的Method（包括父类）
        // Method[] getDeclaredMethods()：获取当前类的所有Method（不包括父类）
        // Method中信息
        // getName()：返回方法名称，例如："getScore"；
        // getReturnType()：返回方法返回值类型，也是一个Class实例，例如：String.class；
        // getParameterTypes()：返回方法的参数类型，是一个Class数组，例如：{String.class, int.class}；
        // getModifiers()：返回方法的修饰符，它是一个int，不同的bit表示不同的含义。

        // 3、调用构造方法
        // 类名.class.newInstance();
        // getConstructor(Class...)：获取某个public的Constructor；
        // getDeclaredConstructor(Class...)：获取某个Constructor；
        // getConstructors()：获取所有public的Constructor；
        // getDeclaredConstructors()：获取所有Constructor。

        // 4、获取继承关系
        // Class getSuperclass()：获取父类类型；
        // Class[] getInterfaces()：获取当前类实现的所有接口。

        // 5、动态代理
        // Proxy.newProxyInstance()
    }
}
