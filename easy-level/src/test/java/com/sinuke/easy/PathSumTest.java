package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PathSumTest {

    @ParameterizedTest
    @MethodSource("testData")
    void hasPathSum(PathSum.TreeNode root, int targetSum, boolean expected) {
        var solution = new PathSum();
        assertEquals(expected, solution.hasPathSum(root, targetSum));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildTree(new Integer[] {5,4,8,11,null,13,4,7,2,null,null,null,1}), 22, true),
                Arguments.of(buildTree(new Integer[] {1,2,3}), 5, false),
                Arguments.of(buildTree(new Integer[] {}), 0, false)
        );
    }

    private static PathSum.TreeNode buildTree(Integer[] array) {
        if (array == null || array.length == 0) return null;

        var root = new PathSum.TreeNode(array[0]);
        Queue<PathSum.TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (i < array.length && !queue.isEmpty()) {
            var current = queue.poll();

            if (array[i] != null) {
                current.left = new PathSum.TreeNode(array[i]);
                queue.offer(current.left);
            }
            i++;

            if (i < array.length && array[i] != null) {
                current.right = new PathSum.TreeNode(array[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

}
