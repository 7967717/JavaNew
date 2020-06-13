package io.rr.collections.queue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * @author romanr on 2/2/2017.
 */

public class MostRecentlyInsertedQueueTest {

    private MostRecentlyInsertedQueue<Integer> queue;

    @Before
    public void setUp() {
        queue = new MostRecentlyInsertedQueue<Integer>(3);
    }

    @Test
    public void testQueue() {
        assertEquals(0, queue.size());
        assertArrayEquals(new Integer[]{}, queue.contents());

        queue.offer(1);
        assertEquals(1, queue.size());
        assertArrayEquals(new Integer[]{1}, queue.contents());

        queue.offer(2);
        assertEquals(2, queue.size());
        assertArrayEquals(new Integer[]{1, 2}, queue.contents() );

        queue.offer(3);
        assertEquals(3, queue.size());
        assertArrayEquals(new Integer[]{1, 2, 3}, queue.contents());

        queue.offer(4);
        assertEquals(3, queue.size());
        assertArrayEquals( new Integer[]{2, 3, 4}, queue.contents());

        queue.offer(5);
        assertEquals(3, queue.size());
        assertArrayEquals( new Integer[]{3, 4, 5}, queue.contents());

        assertEquals(new Integer(3), queue.poll());
        assertEquals(2, queue.size());
        assertArrayEquals(new Integer[]{4, 5}, queue.contents());

        assertEquals(new Integer(4), queue.poll());
        assertEquals(1, queue.size());
        assertArrayEquals(new Integer[]{5}, queue.contents());

        queue.clear();
        assertEquals(0, queue.size());
        assertArrayEquals(new Integer[]{}, queue.contents());

    }

}