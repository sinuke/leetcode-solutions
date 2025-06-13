package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UnivaluedBinaryTreeTest {

    @ParameterizedTest
    @MethodSource("testData")
    void isUnivalTree(UnivaluedBinaryTree.TreeNode root, boolean expected) {
        var solution = new UnivaluedBinaryTree();
        assertEquals(expected, solution.isUnivalTree(root));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildTree(new Integer[]{1,1,1,1,1,null,1}), true),
                Arguments.of(buildTree(new Integer[]{2,2,2,5,2}), false)
        );
    }

    public static UnivaluedBinaryTree.TreeNode buildTree(Integer[] array) {
        if (array == null || array.length == 0) return null;
        return buildTree(array, 0);
    }

    private static UnivaluedBinaryTree.TreeNode buildTree(Integer[] array, int index) {
        if (index >= array.length || array[index] == null) return null;

        var node = new UnivaluedBinaryTree.TreeNode(array[index]);
        node.left = buildTree(array, 2 * index + 1);
        node.right = buildTree(array, 2 * index + 2);

        return node;
    }

}
