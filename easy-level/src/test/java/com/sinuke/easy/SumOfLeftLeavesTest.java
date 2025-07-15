package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SumOfLeftLeavesTest {

    @ParameterizedTest
    @MethodSource("testData")
    void sumOfLeftLeaves(SumOfLeftLeaves.TreeNode root, int expected) {
        var solution = new SumOfLeftLeaves();
        assertEquals(expected, solution.sumOfLeftLeaves2(root));
        assertEquals(expected, solution.sumOfLeftLeaves(root));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildTree(new Integer[]{3,9,20,null,null,15,7}), 24),
                Arguments.of(buildTree(new Integer[]{1}), 0),
                Arguments.of(buildTree(new Integer[]{3,4,5,-7,-6,null,null,-7,null,-5,null,null,null,-4}), -11)
        );
    }

    private static SumOfLeftLeaves.TreeNode buildTree(Integer[] array) {
        if (array == null || array.length == 0) return null;

        var root = new SumOfLeftLeaves.TreeNode(array[0]);
        Queue<SumOfLeftLeaves.TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (i < array.length && !queue.isEmpty()) {
            var current = queue.poll();

            if (array[i] != null) {
                current.left = new SumOfLeftLeaves.TreeNode(array[i]);
                queue.offer(current.left);
            }
            i++;

            if (i < array.length && array[i] != null) {
                current.right = new SumOfLeftLeaves.TreeNode(array[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

}
