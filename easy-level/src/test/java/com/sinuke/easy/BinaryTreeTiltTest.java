package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryTreeTiltTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findTilt(BinaryTreeTilt.TreeNode root, int expected) {
        var solution = new BinaryTreeTilt();
        assertEquals(expected, solution.findTilt(root));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildTree(new Integer[]{1,2,3}), 1),
                Arguments.of(buildTree(new Integer[]{4,2,9,3,5,null,7}), 15),
                Arguments.of(buildTree(new Integer[]{21,7,14,1,1,2,2,3,3}), 9)
        );
    }

    private static BinaryTreeTilt.TreeNode buildTree(Integer[] array) {
        if (array == null || array.length == 0) return null;

        var root = new BinaryTreeTilt.TreeNode(array[0]);
        Queue<BinaryTreeTilt.TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (i < array.length && !queue.isEmpty()) {
            var current = queue.poll();

            if (array[i] != null) {
                current.left = new BinaryTreeTilt.TreeNode(array[i]);
                queue.offer(current.left);
            }
            i++;

            if (i < array.length && array[i] != null) {
                current.right = new BinaryTreeTilt.TreeNode(array[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

}
