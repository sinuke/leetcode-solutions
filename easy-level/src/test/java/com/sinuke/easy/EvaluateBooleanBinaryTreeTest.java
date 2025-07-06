package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EvaluateBooleanBinaryTreeTest {

    @ParameterizedTest
    @MethodSource("testData")
    void evaluateTree(EvaluateBooleanBinaryTree.TreeNode root, boolean expected) {
        var solution = new EvaluateBooleanBinaryTree();
        assertEquals(expected, solution.evaluateTree(root));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildTree(new Integer[]{2,1,3,null,null,0,1}), true),
                Arguments.of(buildTree(new Integer[]{0}), false)
        );
    }

    public static EvaluateBooleanBinaryTree.TreeNode buildTree(Integer[] array) {
        if (array == null || array.length == 0) return null;
        return buildTree(array, 0);
    }

    private static EvaluateBooleanBinaryTree.TreeNode buildTree(Integer[] array, int index) {
        if (index >= array.length || array[index] == null) return null;

        var node = new EvaluateBooleanBinaryTree.TreeNode(array[index]);
        node.left = buildTree(array, 2 * index + 1);
        node.right = buildTree(array, 2 * index + 2);

        return node;
    }

}
