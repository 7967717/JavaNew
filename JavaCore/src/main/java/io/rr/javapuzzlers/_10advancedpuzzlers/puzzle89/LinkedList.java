package io.rr.javapuzzlers._10advancedpuzzlers.puzzle89;

public class LinkedList<E> {
    private Node<E> head = null;

    private class Node<T> {
        T value;
        Node<T> next;

        // Node constructor links the node as a new head
        Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    public void add(E e) {
        head = new Node<E>(e, head);
        // Link node as new head
    }

    public void dump() {
        for (Node<E> n = head; n != null; n = n.next)
            System.out.println(n.value + " ");
    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<String>();
        list.add("world");
        list.add("Hello");
        list.dump();
    }
}
