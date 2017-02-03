package io.rr.collections.queue;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * @author romanr on 2/3/2017.
 */
public class MostRecentlyInsertedBlockingQueueTest {

    private MostRecentlyInsertedBlockingQueue<Integer> queue;

    @Test
    public void put() throws InterruptedException {
        queue = new MostRecentlyInsertedBlockingQueue<>(1);
        queue.offer(1);
        assertEquals(1, queue.size());

        new Thread() {
            public void run() {
                try {
                    queue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        queue.put(2);

        Thread.sleep(100);
        assertEquals(1, queue.size());
    }

    @Test
    public void take() throws Exception {
        queue = new MostRecentlyInsertedBlockingQueue<>(1);
        assertEquals(0, queue.size());

        new Thread() {
            public void run() {
                try {
                    queue.put(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        queue.take();

        Thread.sleep(100);
        assertEquals(queue.size(), 0);
    }

    @Test
    public void offerTrue() throws Exception {
        queue = new MostRecentlyInsertedBlockingQueue<>(1);
        queue.offer(1);
        final boolean[] result = new boolean[1];

        new Thread() {
            public void run() {
                try {
                    result[0] = queue.offer(2, 100, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread() {
            public void run() {
                try {
                    Thread.sleep(50);
                    queue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        Thread.sleep(200);
        assertEquals(true, result[0]);
    }

    @Test
    public void offerFalse() throws Exception {
        queue = new MostRecentlyInsertedBlockingQueue<>(1);
        queue.offer(1);
        final boolean[] result = new boolean[1];

        new Thread() {
            public void run() {
                try {
                    result[0] = queue.offer(2, 50, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread() {
            public void run() {
                try {
                    Thread.sleep(100);
                    queue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        Thread.sleep(200);
        assertEquals(false, result[0]);
    }


    @Test
    public void drainTo() throws Exception {
        queue = new MostRecentlyInsertedBlockingQueue<>(3);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        ArrayList<Integer> list = new ArrayList<>();

        int i = queue.drainTo(list, 2);
        assertEquals(2, i);
        assertEquals(Arrays.asList(1, 2), list);
        assertEquals(3, queue.peek().intValue());
    }

}