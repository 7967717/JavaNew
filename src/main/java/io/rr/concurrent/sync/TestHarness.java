package io.rr.concurrent.sync;

import java.util.concurrent.CountDownLatch;

/**
 * @author roman on 5/2/17.
 */
public class TestHarness {
    public static long timeTasks(int nThreads, final Runnable task)
            throws InterruptedException {
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(nThreads);
        System.out.println("before fori");
        for (int i = 0; i < nThreads; i++) {
            Thread t = new Thread() {
                public void run() {
                    try {
                        //wait to start
                        startGate.await();
                        try {
                            task.run();
                        } finally {
                            //count  down  on  the  ending  gate
                            endGate.countDown();
                        }
                    } catch (InterruptedException ignored) {
                    }
                }
            };
            t.start();
        }
        System.out.println("after fori");
        long start = System.nanoTime();
        //start
        startGate.countDown();
        System.out.println("start");
        //wait count  down the  end
        endGate.await();
        System.out.println("end");
        long end = System.nanoTime();
        return end - start;
    }

    public static void main(String[] args) throws InterruptedException {
        long l = timeTasks(5, new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread());
            }
        });
        System.out.println(l);
    }
}
