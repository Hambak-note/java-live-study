package org.example.week4.stack;

import org.example.week4.linkedlist_v3.SingleLinkedList;

import java.util.Stack;

public class CustomStack<T> extends SingleLinkedList<T> {


    public void push(T item) {
        addFirst(item);
    }

    public T pop() {
        return removeFirst();
    }

    public T peek() {
        return get(0);
    }

    public int size() {
        return super.size();
    }

    public boolean isEmpty() {
        return size()==0;
    }


}
