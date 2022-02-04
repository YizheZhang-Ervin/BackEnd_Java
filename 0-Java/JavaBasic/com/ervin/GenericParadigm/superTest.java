package com.ervin.GenericParadigm;

public class superTest {
    public static void main(String[] args) {
        Pair6<Number> p1 = new Pair6<>(12.3, 4.56);
        Pair6<Integer> p2 = new Pair6<>(123, 456);
        setSame(p1, 100);
        setSame(p2, 200);
        System.out.println(p1.getFirst() + ", " + p1.getLast());
        System.out.println(p2.getFirst() + ", " + p2.getLast());
    }

    static void setSame(Pair6<? super Integer> p, Integer n) {
        p.setFirst(n);
        p.setLast(n);
    }

}

class Pair6<T> {
    private T first;
    private T last;

    public Pair6(T first, T last) {
        this.first = first;
        this.last = last;
    }

    public T getFirst() {
        return first;
    }
    public T getLast() {
        return last;
    }
    public void setFirst(T first) {
        this.first = first;
    }
    public void setLast(T last) {
        this.last = last;
    }
}