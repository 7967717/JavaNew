package io.rr.concurrent;

/**
 * @author roman on 4/20/17.
 */
public class SimpleDeadLock {

    public static void main(String[] args) throws InterruptedException {
        Thread main = Thread.currentThread();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("in " + Thread.currentThread());
                    main.join();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        System.out.println("in " + Thread.currentThread());
        thread.join();
    }
}
