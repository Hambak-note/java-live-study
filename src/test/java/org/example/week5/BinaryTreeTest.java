package org.example.week5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class BinaryTreeTest {

    @Test
    @DisplayName("이진트리 BFS 테스트")
    void testBFS() {
        BinaryTree tree = new BinaryTree();
        tree.add(5);
        tree.add(3);
        tree.add(7);
        tree.add(2);
        tree.add(4);
        tree.add(6);
        tree.add(8);

        List<Integer> expectedOutput = List.of(5, 3, 7, 2, 4, 6, 8);
        List<Integer> actualOutput = tree.bfs(tree.root);

        assertArrayEquals(expectedOutput.toArray(), actualOutput.toArray());
    }

    @Test
    @DisplayName("이진트리 DFS 테스트")
    void testDFS() {
        BinaryTree tree = new BinaryTree();
        tree.add(5);
        tree.add(3);
        tree.add(7);
        tree.add(2);
        tree.add(4);
        tree.add(6);
        tree.add(8);

        List<Integer> expectedOutput = List.of(2, 3, 4, 5, 6, 7, 8);
        List<Integer> actualOutput = tree.dfs(tree.root);

        assertArrayEquals(expectedOutput.toArray(), actualOutput.toArray());
    }
}
