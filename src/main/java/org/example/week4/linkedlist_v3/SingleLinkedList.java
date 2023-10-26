package org.example.week4.linkedlist_v3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SingleLinkedList<T> {

    private Node<T> head; //첫 번째 노드
    private int size;

    public SingleLinkedList() {
        head = null;
        size = 0;
    }

    //inner class
    //private 으로 선언되어 있기 때문에 외부에서는 Node에 대해서 알 수 없다.
    private static class Node<T> {

        public T data;
        public Node<T> next;

        public Node(T item) {
            data = item;
            next = null;
        }
    }

    public Iterator<T> iterator() {

        return new MyIterator();
    }

    private class MyIterator implements Iterator<T> {

        private Node<T> nextNode;
        private int index;

        public MyIterator() {

            nextNode = head;
            index = 0;
        }

        public boolean hasNext() {

            return (nextNode != null);
        }

        public T next() {

            if(nextNode == null)
                throw new NoSuchElementException();

            T val = nextNode.data;
            nextNode = nextNode.next;
            index++;
            return val;
        }

        public void remove() {

            SingleLinkedList.this.remove(index);
        }
    }

    //addFirst 등은 Node에 대해 알아야 접근할 수 있다.
    //때문에 이러한 메소드 또한 private으로 선언한다.

    //연결 리스트의 가장 앞에 Node를 추가한다.
    private void addFirst(T item) {

        Node<T> newNode = new Node<T>(item);

        newNode.next = head;
        head = newNode;
        size++;
    }

    //특정 노드의 다음 위치에 노드를 추가한다.
    private void addAfter(Node<T> before, T item) {

        Node<T> temp = new Node<T>(item);
        temp.next = before.next;
        before.next = temp;
        size++;
    }

    private T removeFirst() {

        if(head == null)
            return null;

        T temp = head.data;
        head = head.next;
        size--;
        return temp;
    }

    //특정 노드의 다음 노드를 제거한다.
    private T removeAfter( Node<T> before) {

        if( before.next == null ) {
            return null;
        }

        T temp = before.next.data;
        before.next = before.next.next;
        size--;
        return temp;
    }

    public int indexOf( T item ) {

        Node<T> p = head;
        int index = 0;

        while(p != null) {
            if (p.data.equals(item))
                return index;
            p = p.next;
            index++;
        }
        return -1;
    }

    private Node<T> getNode(int index) {

        //index의 유효성 검증
        if(index < 0 || index >= size) {
            return null;
        }

        Node<T> p = head;
        for(int i = 0; i<index; i++) {
            p = p.next;
        }
        return p;
    }

    public T get(int index) {

        //index의 유효성 검증
        if(index < 0 || index >= size) {
            return null;
        }

        return getNode(index).data;
    }
    public void add( int index, T item) {

        //index의 유효성 검증
        //사이즈 비교시 >= 가 되는 이유는 노드를 추가하는 것이기 때문에 기존 사이즈에 +1 되는 범위까지 가능하다.
        if(index < 0 || index > size)
            throw new IndexOutOfBoundsException();

        if(index == 0)
            addFirst(item);
        else {
            Node<T> q = getNode(index - 1);
            addAfter(q, item);
        }

    }

    public T remove(int index) {

        //index의 유효성 검증
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        if(index == 0)
            return removeFirst();

        Node<T> prev = getNode(index-1);
        return removeAfter(prev);
    }

    public boolean remove (T item) {

        Node<T> p = head;
        Node<T> q = null;

        while(p!=null && !p.data.equals(item)) {
            q = p;
            p = p.next;
        }

        if(p == null)
            return false;

        if(q==null){
            T tmp = removeFirst();
            return (tmp != null);
        }
        else {
            T tmp = removeAfter(q);
            return (tmp != null);
        }
    }

    public int size() {
        return size;
    }

}
