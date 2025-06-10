package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumDepthOfBinaryTreeTest {

    @ParameterizedTest
    @MethodSource("testData")
    void maxDepth(MaximumDepthOfBinaryTree.TreeNode root, int expected) {
        var solution = new MaximumDepthOfBinaryTree();
        assertEquals(expected, solution.maxDepth(root));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildTree(new Integer[]{3,9,20,null,null,15,7}), 3),
                Arguments.of(buildTree(new Integer[]{1,null,2}), 2)
        );
    }

    private static MaximumDepthOfBinaryTree.TreeNode buildTree(Integer[] array) {
        if (array == null || array.length == 0) return null;
        return buildTree(array, 0);
    }

    private static MaximumDepthOfBinaryTree.TreeNode buildTree(Integer[] array, int index) {
        if (index >= array.length || array[index] == null) return null;

        var node = new MaximumDepthOfBinaryTree.TreeNode(array[index]);
        node.left = buildTree(array, 2 * index + 1);
        node.right = buildTree(array, 2 * index + 2);

        return node;
    }

}
