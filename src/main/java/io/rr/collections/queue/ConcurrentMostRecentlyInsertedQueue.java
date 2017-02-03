package io.rr.collections.queue;

import java.util.AbstractQueue;
import java.util.Collections;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author romanr on 2/2/2017.
 */
public class ConcurrentMostRecentlyInsertedQueue<E> extends AbstractQueue<E> implements Queue<E> {

    protected AtomicInteger size;
    protected final int capacity;
    private volatile Node<E> head;
    private volatile Node<E> tail;
    protected final Lock lock = new ReentrantLock();

    public ConcurrentMostRecentlyInsertedQueue(int capacity) {
        this.capacity = capacity;
        size = new AtomicInteger(0);
    }

    /**
     * Returns an empty iterator
     * iteration is not thread safe.
     */
    @Override
    public Iterator<E> iterator() {
        return Collections.emptyIterator();
    }

    @Override
    public int size() {
        return size.get();
    }

    /**
     * Inserts the specified element into this queue tail.
     */
    @Override
    public boolean offer(E e) {
        lock.lock();
        if (size.get() == capacity) {
            poll();
        }
        Node<E> last = tail;
        Node<E> newNode = new Node<>(last, e, null);
        tail = newNode;
        if (last == null) {
            head = newNode;
        } else {
            last.tail = newNode;
        }
        size.incrementAndGet();
        lock.unlock();
        return true;
    }

    /**
     * Retrieves and removes the head of this queue.
     */
    @Override
    public E poll() {
        lock.lock();
        if (head == null) {
            return null;
        }
        E element = head.item;
        head = head.tail;
        size.decrementAndGet();
        lock.unlock();
        return element;
    }

    /**
     * Retrieves, but does not remove, the head of this queue.
     */
    @Override
    public E peek() {
        return (head == null) ? null : head.item;
    }

    public E[] contents() {
        lock.lock();
        E[] array = (E[]) new Object[size.get()];
        Iterator iterator = new Iter();
        int i = 0;
        while (iterator.hasNext()) {
            array[i] = (E) iterator.next();
            i++;
        }
        lock.unlock();
        return array;
    }

    private static class Node<E> {
        volatile E item;
        volatile Node<E> head;
        volatile Node<E> tail;

        Node(Node<E> head, E element, Node<E> tail) {
            this.item = element;
            this.head = head;
            this.tail = tail;
        }
    }

    private class Iter implements Iterator<E> {

        volatile Node<E> next;

        Iter() {
            this.next = head;
        }

        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public E next() {
            E item = next.item;
            next = next.tail;
            return item;
        }

    }

}
