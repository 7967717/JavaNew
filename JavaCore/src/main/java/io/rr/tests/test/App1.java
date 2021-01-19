package io.rr.tests.test;

public class App1 {
    public static void main(String[] args) {
        A a0 = new A(null, "a0");
        A a1 = new A(a0, "a1");
        A a2 = new A(a1, "a2");

        System.out.println(a2);
        System.out.println(a2.reverse(a2));
    }

}

class A {
    public A(A next, String name) {
        this.next = next;
        this.name = name;
    }

    A next;
    String name;

    A reverse(A a) {
        return go(a, a.next);
    }

    private A go(A current, A next) {
        A previous = next.next;
        next.next = current;
        if(next == null) {
            return current;
        } else {
            return go(previous, next);
        }
    }

    @Override
    public String toString() {
        return "A{" +
                "next=" + next +
                ", name='" + name + '\'' +
                '}';
    }
}
