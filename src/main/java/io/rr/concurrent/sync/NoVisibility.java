package io.rr.concurrent.sync;

/**
 * @author roman on 2/13/17.
 */
public class NoVisibility {
    private static volatile boolean ready;
    private static int number;

    private static class Reader extends Thread {
        @Override
        public void run() {
            while (!ready) {
                Thread.yield();
                System.out.println(number);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Reader().start();
//        Thread.sleep(8);
        number = 7;
        ready = true;
    }
}
