package org.example.week4.queue;

import org.example.week4.linkedlist_v3.SingleLinkedList;

public class CustomQueue<T> extends SingleLinkedList<T> {

    public void enqueue(T item) {
        add(size(),item);
    }

    public T dequeue() {
        return removeFirst();
    }

    public T peek() {
        return get(0);
    }

    public int size() {
        return super.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }
}
