package io.rr.concurrent.jmm;

import java.util.BitSet;
import java.util.concurrent.CountDownLatch;

/**
 * @author roman on 4/17/17.
 */
public class AnExample {
    public static void main(String[] args) throws Exception {
        BitSet bs = new BitSet();
        CountDownLatch latch = new CountDownLatch(1);
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                try {
                    latch.await();
                    Thread.sleep(1000);
                } catch (Exception ex) {
                }
//                bs.set(1);
                synchronized (bs) {
                    bs.set(1);
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                try {
                    latch.await();
                    Thread.sleep(1000);
                } catch (Exception e) {
                }
//                bs.set(2);
                synchronized (bs) {
                    bs.set(2);
                }
            }
        });

        t1.start();
        t2.start();
        latch.countDown();
        t1.join();
        t2.join();
        // crucial part here:
        System.out.println(bs.get(1));
        System.out.println(bs.get(2));
    }
}
