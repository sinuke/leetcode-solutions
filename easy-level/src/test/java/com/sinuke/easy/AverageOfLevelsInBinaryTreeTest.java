package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AverageOfLevelsInBinaryTreeTest {

    @ParameterizedTest
    @MethodSource("testData")
    void averageOfLevels(AverageOfLevelsInBinaryTree.TreeNode root, List<Double> expected) {
        var solution = new AverageOfLevelsInBinaryTree();
        assertEquals(expected, solution.averageOfLevels(root));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildTree(new Integer[]{3,9,20,null,null,15,7}), List.of(3.00000d,14.50000d,11.00000d)),
                Arguments.of(buildTree(new Integer[]{3,9,20,15,7}), List.of(3.00000d,14.50000d,11.00000d)),
                Arguments.of(buildTree(new Integer[]{2147483647,2147483647,2147483647}), List.of(2147483647.00000d,2147483647.00000d))
        );
    }

    public static AverageOfLevelsInBinaryTree.TreeNode buildTree(Integer[] array) {
        if (array == null || array.length == 0) return null;
        return buildTree(array, 0);
    }

    private static AverageOfLevelsInBinaryTree.TreeNode buildTree(Integer[] array, int index) {
        if (index >= array.length || array[index] == null) return null;

        var node = new AverageOfLevelsInBinaryTree.TreeNode(array[index]);
        node.left = buildTree(array, 2 * index + 1);
        node.right = buildTree(array, 2 * index + 2);

        return node;
    }

}
