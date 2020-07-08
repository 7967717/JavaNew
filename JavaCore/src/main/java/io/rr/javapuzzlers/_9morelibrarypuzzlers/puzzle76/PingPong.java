package io.rr.javapuzzlers._9morelibrarypuzzlers.puzzle76;

public class PingPong {
    public static synchronized void main(String[] a) {
        Thread t = new Thread() {
            public void run() {
                pong();
            }
        };
        //t.run(); wrong
        t.start();
        System.out.print("Ping");
    }

    static synchronized void pong() {
        System.out.print("Pong");
    }
}
