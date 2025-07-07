package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryTreePostorderTraversalTest {

    @ParameterizedTest
    @MethodSource("testData")
    void postorderTraversal(BinaryTreePostorderTraversal.TreeNode root, List<Integer> expected) {
        var solution = new BinaryTreePostorderTraversal();
        assertEquals(expected, solution.postorderTraversal(root));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildTree(new Integer[]{1,null,2,3}), List.of(3,2,1)),
                Arguments.of(buildTree(new Integer[]{1,2,3,4,5,null,8,null,null,6,7,9}), List.of(4,6,7,5,2,9,8,3,1)),
                Arguments.of(buildTree(new Integer[]{}), List.of()),
                Arguments.of(buildTree(new Integer[]{1}), List.of(1))
        );
    }

    private static BinaryTreePostorderTraversal.TreeNode buildTree(Integer[] array) {
        if (array == null || array.length == 0) return null;

        var root = new BinaryTreePostorderTraversal.TreeNode(array[0]);
        Queue<BinaryTreePostorderTraversal.TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (i < array.length && !queue.isEmpty()) {
            var current = queue.poll();

            if (array[i] != null) {
                current.left = new BinaryTreePostorderTraversal.TreeNode(array[i]);
                queue.offer(current.left);
            }
            i++;

            if (i < array.length && array[i] != null) {
                current.right = new BinaryTreePostorderTraversal.TreeNode(array[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

}
