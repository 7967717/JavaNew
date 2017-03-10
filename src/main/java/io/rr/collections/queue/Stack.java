package io.rr.collections.queue;

/**
 * @author roman on 3/10/17.
 */
public class Stack<E> {

    private int size;
    private int capacity;
    private int index = -1;
    public E[] data;

    public Stack(int capacity) {
        this.capacity = capacity;
        data = (E[]) new Object[capacity];
    }

    public E add(E e) {
        if (size == capacity) {
            capacity = capacity * 2;
            E[] oldData = data;
            data = (E[]) new Object[capacity];
            for (int i = 0; i < size; i++) {
                data[i] = oldData[i];
            }
        }

        index++;
        size++;

        return data[index] = e;
    }

    public E remove() {
        E removed = data[index];
        data[index] = null;
        index--;
        size--;

        return removed;
    }

}
