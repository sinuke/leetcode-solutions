package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SymmetricTreeTest {

    @ParameterizedTest
    @MethodSource("testData")
    void isSymmetric(SymmetricTree.TreeNode root, boolean expected) {
        var solution = new SymmetricTree();
        assertEquals(expected, solution.isSymmetric(root));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildTree(new Integer[] {1,2,2,3,4,4,3}), true),
                Arguments.of(buildTree(new Integer[] {1,2,2,null,3,null,3}), false)
        );
    }

    private static SymmetricTree.TreeNode buildTree(Integer[] array) {
        if (array == null || array.length == 0) return null;

        var root = new SymmetricTree.TreeNode(array[0]);
        Queue<SymmetricTree.TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (i < array.length && !queue.isEmpty()) {
            var current = queue.poll();

            if (array[i] != null) {
                current.left = new SymmetricTree.TreeNode(array[i]);
                queue.offer(current.left);
            }
            i++;

            if (i < array.length && array[i] != null) {
                current.right = new SymmetricTree.TreeNode(array[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

}
