package io.rr.java8.definterface;

/**
 * @author rrudenko on 27.06.2017.
 */
public interface A {
    default void f() {
        System.out.println("In A");
    }
}

interface B {
    default void f() {
        System.out.println("In B");
    }
}

class C implements A, B {
    public static void main(String[] args) {
        new C().f();
    }

    @Override
    public void f() {
        System.out.println("In C");
    }
}