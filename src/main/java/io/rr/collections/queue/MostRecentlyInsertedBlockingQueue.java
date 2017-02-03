package io.rr.collections.queue;

import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;

/**
 * @author romanr on 2/2/2017.
 */
public class MostRecentlyInsertedBlockingQueue<E> extends ConcurrentMostRecentlyInsertedQueue<E> implements BlockingQueue<E> {
    private Condition empty = lock.newCondition();
    private Condition full = lock.newCondition();

    public MostRecentlyInsertedBlockingQueue(int capacity) {
        super(capacity);
    }

    /**
     * Inserts the specified element into this queue, waiting if necessary
     * for space to become available.
     */
    @Override
    public void put(E e) throws InterruptedException {
        lock.lock();
        try {
            if (size.get() == capacity) {
                full.await();
            }
            offer(e);
            empty.signalAll();
        } finally {
            lock.unlock();
        }
    }

    /**
     * Inserts the specified element into this queue, waiting up to the
     * specified wait time if necessary for space to become available.
     */
    @Override
    public boolean offer(E e, long timeout, TimeUnit unit) throws InterruptedException {
        lock.lock();
        boolean result;
        try {
            result = false;
            if (size.get() == capacity) {
                result = full.await(timeout, unit);
            }
            offer(e);
            empty.signalAll();
        } finally {
            lock.unlock();
        }
        return result;
    }

    /**
     * Retrieves and removes the head of this queue, waiting if necessary
     * until an element becomes available.
     */
    @Override
    public E take() throws InterruptedException {
        lock.lock();
        E e;
        try {
            if (size.get() == 0) {
                empty.await();
            }
            e = poll();
            full.signalAll();
        } finally {
            lock.unlock();
        }
        return e;
    }

    /**
     * Retrieves and removes the head of this queue, waiting up to the
     * specified wait time if necessary for an element to become available.
     */
    @Override
    public E poll(long timeout, TimeUnit unit) throws InterruptedException {
        lock.lock();
        E e;
        try {
            boolean result = false;
            if (size.get() == 0) {
                result = empty.await(timeout, unit);
            }
            e = null;
            if (result) {
                e = poll();
                full.signalAll();
            }
        } finally {
            lock.unlock();
        }
        return e;
    }

    /**
     * Returns the number of additional elements that this queue can ideally
     * accept without blocking
     */
    @Override
    public int remainingCapacity() {
        return capacity - size.get();
    }

    /**
     * Removes all available elements from this queue and adds them
     * to the given collection.
     */
    @Override
    public int drainTo(Collection<? super E> c) {
        return drainTo(c, Integer.MAX_VALUE);
    }

    /**
     * Removes at most the given number of available elements from
     * this queue and adds them to the given collection.
     */
    @Override
    public int drainTo(Collection<? super E> c, int maxElements) {
        if (maxElements <= 0)
            return 0;

        lock.lock();
        try {
            int n = Math.min(maxElements, size.get());
            int i = 0;
            while (i < n) {
                E x = poll();
                c.add(x);
                i++;
            }
            return n;
        } finally {
            lock.unlock();
        }
    }

}
