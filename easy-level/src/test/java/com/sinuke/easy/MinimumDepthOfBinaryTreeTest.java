package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumDepthOfBinaryTreeTest {

    @ParameterizedTest
    @MethodSource("testData")
    void minDepth(MinimumDepthOfBinaryTree.TreeNode root, int expected) {
        var solution = new MinimumDepthOfBinaryTree();
        assertEquals(expected, solution.minDepth(root));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildTree(new Integer[] {3,9,20,null,null,15,7}), 2),
                Arguments.of(buildTree(new Integer[] {2,null,3,null,4,null,5,null,6}), 5),
                Arguments.of(buildTree(new Integer[] {}), 0)
        );
    }

    private static MinimumDepthOfBinaryTree.TreeNode buildTree(Integer[] array) {
        if (array == null || array.length == 0) return null;

        var root = new MinimumDepthOfBinaryTree.TreeNode(array[0]);
        Queue<MinimumDepthOfBinaryTree.TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (i < array.length && !queue.isEmpty()) {
            var current = queue.poll();

            if (array[i] != null) {
                current.left = new MinimumDepthOfBinaryTree.TreeNode(array[i]);
                queue.offer(current.left);
            }
            i++;

            if (i < array.length && array[i] != null) {
                current.right = new MinimumDepthOfBinaryTree.TreeNode(array[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

}
