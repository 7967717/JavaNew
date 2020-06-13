package io.rr.concurrent.jmm;

/**
 * @author roman on 4/16/17.
 */
public class SetCheck {
    private static int  a = 0;
    private static long b = 0;

    static void set() {
        a =  1;
        b = -1;
    }

    static boolean check() {
        return ((b ==  0) ||
                (b == -1 && a == 1));
    }

    public static void main(String[] args) {
//        new Thread(() -> set()).start();
        new Thread(() -> System.out.println(check())).start();
        new Thread(() -> set()).start();

    }
}
