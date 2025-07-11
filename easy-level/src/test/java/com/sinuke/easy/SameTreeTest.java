package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SameTreeTest {

    @ParameterizedTest
    @MethodSource("testData")
    void isSameTree(SameTree.TreeNode p, SameTree.TreeNode q, boolean expected) {
        var solution = new SameTree();
        assertEquals(expected, solution.isSameTree(p, q));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildTree(new Integer[] {1,2,3}), buildTree(new Integer[]{1,2,3}), true),
                Arguments.of(buildTree(new Integer[] {1,2}), buildTree(new Integer[]{1,null,2}), false),
                Arguments.of(buildTree(new Integer[] {1,2,1}), buildTree(new Integer[]{1,1,2}), false)
        );
    }

    private static SameTree.TreeNode buildTree(Integer[] array) {
        if (array == null || array.length == 0) return null;

        var root = new SameTree.TreeNode(array[0]);
        Queue<SameTree.TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (i < array.length && !queue.isEmpty()) {
            var current = queue.poll();

            if (array[i] != null) {
                current.left = new SameTree.TreeNode(array[i]);
                queue.offer(current.left);
            }
            i++;

            if (i < array.length && array[i] != null) {
                current.right = new SameTree.TreeNode(array[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

}
