package com.ervin.GenericParadigm;

public class extendsTest {
    public static void main(String[] args) {
        Pair5<Integer> p = new Pair5<>(123, 456);
        int n = add(p);
        System.out.println(n);
    }

    static int add(Pair5<? extends Number> p) {
        Number first = p.getFirst();
        Number last = p.getLast();
        return first.intValue() + last.intValue();
    }
}

class Pair5<T> {
    private T first;
    private T last;
    public Pair5(T first, T last) {
        this.first = first;
        this.last = last;
    }
    public T getFirst() {
        return first;
    }
    public T getLast() {
        return last;
    }
}