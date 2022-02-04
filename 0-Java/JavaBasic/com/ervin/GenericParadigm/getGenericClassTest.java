package com.ervin.GenericParadigm;

public class getGenericClassTest {
    public static void main(String[] args) {
        Pair3<String> p1 = new Pair3<>("Hello", "world");
        Pair3<Integer> p2 = new Pair3<>(123, 456);
        Class c1 = p1.getClass();
        Class c2 = p2.getClass();
        System.out.println(c1==c2); // true
        System.out.println(c1==Pair3.class); // true

    }
}

class Pair3<T> {
    private T first;
    private T last;
    public Pair3(T first, T last) {
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
