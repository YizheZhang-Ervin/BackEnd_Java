package com.ervin.GenericParadigm;

import java.lang.reflect.Array;

public class GenericAndReflectionTest {
    // 可以利用可变参数创建泛型数组T[]：
    @SafeVarargs
    static <T> T[] asArray(T... objs) {
        return objs;
    }

    // 必须借助Class<T>来创建泛型数组：
    String[] createArray(Class<String> cls) {
        return (String[]) Array.newInstance(cls, 5);
    }

    public static void main(String[] args) {
        // 带泛型的数组实际上是编译器的类型擦除
        // 由于拿不到原始数组的引用，就只能对泛型数组ps进行操作，这种操作就是安全的
        // @SuppressWarnings("unchecked")
        // Pair1<String>[] ps = (Pair1<String>[]) new Pair1[2];
        // 不安全
        Pair1[] arr = new Pair1[2];
        Pair1<String>[] ps = (Pair1<String>[]) arr;
        System.out.println(ps.getClass() == Pair1[].class); // true
        String s1 = (String) arr[0].getFirst();
        String s2 = ps[0].getFirst();

        // 利用可变参数创建泛型数组T[]
        String[] ss = asArray("a", "b", "c");
        Integer[] ns = asArray(1, 2, 3);
    }
}
