package com.ervin.GenericParadigm;

public class Pair1<T> {
    private T first;
    private T last;
    public Pair1(T first, T last) {
        this.first = first;
        this.last = last;
    }
    public T getFirst() { return first; }
    public T getLast() { return last; }

    // 静态泛型方法应该使用其他类型区分:
    public static <K> Pair1<K> create(K first, K last) {
        return new Pair1<K>(first, last);
    }
}