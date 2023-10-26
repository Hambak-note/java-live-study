package org.example;

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
    }
}