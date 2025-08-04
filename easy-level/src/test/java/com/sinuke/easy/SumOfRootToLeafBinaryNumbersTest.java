package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SumOfRootToLeafBinaryNumbersTest {

    @ParameterizedTest
    @MethodSource("testData")
    void sumRootToLeaf(SumOfRootToLeafBinaryNumbers.TreeNode root, int expected) {
        var solution = new SumOfRootToLeafBinaryNumbers();
        assertEquals(expected, solution.sumRootToLeaf(root));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildTree(new Integer[]{1,0,1,0,1,0,1}), 22),
                Arguments.of(buildTree(new Integer[]{0}), 0)
        );
    }

    private static SumOfRootToLeafBinaryNumbers.TreeNode buildTree(Integer[] array) {
        if (array == null || array.length == 0) return null;

        var root = new SumOfRootToLeafBinaryNumbers.TreeNode(array[0]);
        Queue<SumOfRootToLeafBinaryNumbers.TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (i < array.length && !queue.isEmpty()) {
            var current = queue.poll();

            if (array[i] != null) {
                current.left = new SumOfRootToLeafBinaryNumbers.TreeNode(array[i]);
                queue.offer(current.left);
            }
            i++;

            if (i < array.length && array[i] != null) {
                current.right = new SumOfRootToLeafBinaryNumbers.TreeNode(array[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

}
