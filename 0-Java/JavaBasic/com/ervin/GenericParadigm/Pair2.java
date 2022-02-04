package com.ervin.GenericParadigm;

public class Pair2<T, K> {
    private T first;
    private K last;
    public Pair2(T first, K last) {
        this.first = first;
        this.last = last;
    }
    public T getFirst() { return first; }
    public K getLast() { return last; }
}