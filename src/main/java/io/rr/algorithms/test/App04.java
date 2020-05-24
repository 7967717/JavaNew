package io.rr.algorithms.test;

public class App04 {
    public static void main(String[] args) {
        A b = new B(1, 1, 1);
        B b1 = new B(1, 1, 1);
        System.out.println(b.a);
        System.out.println(b1.a);
    }
}

class A {
    int a;
    A (int a) {
        this.a = a;
    }
}

class B extends A {
    int a;
    int b;
    int c;

    B(int a, int b) {
        super(a);
        this.b = b;
    }

    B(int a, int b, int c) {
        this(a, b);
        this.c = c;
    }
}
