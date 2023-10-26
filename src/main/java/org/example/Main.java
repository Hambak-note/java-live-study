package org.example;

import org.example.week4.queue.CustomQueue;
import org.example.week4.stack.CustomStack;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        CustomStack<Integer> customStack = new CustomStack<>();
        customStack.push(3);
        customStack.push(4);
        customStack.push(5);
        customStack.push(6);

        System.out.println("사이즈 : " + customStack.size());
        System.out.println("pop : " + customStack.pop());
        System.out.println("peek : " + customStack.peek());

        CustomQueue<Integer> customQueue = new CustomQueue<>();
        customQueue.enqueue(3);
        customQueue.enqueue(4);
        customQueue.enqueue(5);
        customQueue.enqueue(6);

        System.out.println("사이즈 : " + customQueue.size());
        System.out.println("dequeue : " + customQueue.dequeue());
        System.out.println("peek : " + customQueue.peek());

    }
}