package io.rr.javapuzzlers._9morelibrarypuzzlers.puzzle85;

public class Lazy {
    private static boolean initialized = false;

    private static Thread t = new Thread(new Runnable() {
        public void run() {
            initialized = true;
        }
    });

    static {
//        Thread t = new Thread(new Runnable() {
//            public void run() {
//                initialized = true;
//            }
//        });
        t.start();
//        try {
//            t.join();
//        } catch(InterruptedException e) {
//            throw new AssertionError(e);
//        }
    }

    public static void main(String[] args) {
        try {
            t.join();
        } catch (InterruptedException e) {
            throw new AssertionError(e);
        }
        System.out.println(initialized);
    }
}
