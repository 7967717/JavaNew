package io.rr.collections.queue;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.Assert.*;

/**
 * @author romanr on 2/2/2017.
 */
public class ConcurrentMostRecentlyInsertedQueueTest {

    private ConcurrentMostRecentlyInsertedQueue<Integer> queue;

    @Before
    public void setUp() {
        queue = new ConcurrentMostRecentlyInsertedQueue<Integer>(3);
    }

    @Test
    public void testQueue() throws InterruptedException {
        assertEquals(queue.size(), 0);
        assertArrayEquals(queue.contents(), new Integer[]{});
        System.out.println("array " + Arrays.toString(queue.contents()));

        ExecutorService executor0 = Executors.newCachedThreadPool();

        for (int i = 1; i < 6; i++) {
            executor0.execute(new OfferTask(i));
        }

        ExecutorService executor1 = Executors.newCachedThreadPool();

        for (int i = 1; i < 4; i++) {
            executor0.execute(new PollTask());
        }

        Thread.sleep(1000);
        System.out.println("_______________");
        System.out.println(queue.size());
        System.out.println("array " + Arrays.toString(queue.contents()));

    }

    private class OfferTask implements Runnable{

        Integer elem;

        OfferTask(Integer elem) {
            this.elem = elem;
        }

        @Override
        public void run() {
            queue.offer(elem);
            System.out.println("offer " + elem);
            System.out.println("offer size " + queue.size());
            System.out.println("array " + Arrays.toString(queue.contents()));
        }
    }

    private class PollTask implements Runnable{

        @Override
        public void run() {
            System.out.println("poll " + queue.poll());
            System.out.println("poll size " + queue.size());
            System.out.println("array " + Arrays.toString(queue.contents()));
        }
    }

}