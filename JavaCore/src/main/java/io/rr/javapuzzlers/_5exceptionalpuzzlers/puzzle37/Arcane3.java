package io.rr.javapuzzlers._5exceptionalpuzzlers.puzzle37;

interface Type1 {
    void f() throws CloneNotSupportedException;
}

interface Type2 {
    void f() throws InterruptedException;
}

interface Type3 extends Type1, Type2 {
}

public class Arcane3 implements Type3 {
    public void f() {
        System.out.println("Hello world");
    }

    public static void main(String[] args) {

        Type1 t1 = new Arcane3();
        Type2 t2 = new Arcane3();
        Type3 t3 = new Arcane3();

        try {
            t1.f();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        try {
            t2.f();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t3.f();
    }
}
