package org.example.week5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.List;

class BinaryTree {
    Node root;

    private static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public BinaryTree() {
        root = null;
    }

    // 값을 이진 트리에 추가하는 메서드
    public void add(int value) {
        root = addRecursive(root, value);
    }

    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        }

        return current;
    }

    // BFS (너비 우선 탐색)를 수행하는 메서드
    public List<Integer> bfs(Node node) {
        List<Integer> result = new ArrayList<>();
        if (node == null) {
            return result;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            result.add(current.value);

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }

        return result;
    }

    // DFS (깊이 우선 탐색)를 수행하는 메서드 (왼쪽, 루트, 오른쪽 순)
    public List<Integer> dfs(Node node) {
        List<Integer> result = new ArrayList<>();
        dfsInOrder(node, result);
        return result;
    }

    private void dfsInOrder(Node node, List<Integer> result) {
        if (node != null) {
            dfsInOrder(node.left, result);
            result.add(node.value);
            dfsInOrder(node.right, result);
        }
    }
}


