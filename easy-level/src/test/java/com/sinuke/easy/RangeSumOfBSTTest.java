package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RangeSumOfBSTTest {

    @ParameterizedTest
    @MethodSource("testData")
    void rangeSumBST(RangeSumOfBST.TreeNode root, int low, int high, int expected) {
        var solution = new RangeSumOfBST();
        assertEquals(expected, solution.rangeSumBST(root, low, high));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildTree(new Integer[]{10,5,15,3,7,null,18}), 7, 15, 32),
                Arguments.of(buildTree(new Integer[]{10,5,15,3,7,13,18,1,null,6}), 6, 10, 23)
        );
    }

    public static RangeSumOfBST.TreeNode buildTree(Integer[] array) {
        if (array == null || array.length == 0) return null;
        return buildTree(array, 0);
    }

    private static RangeSumOfBST.TreeNode buildTree(Integer[] array, int index) {
        if (index >= array.length || array[index] == null) return null;

        var node = new RangeSumOfBST.TreeNode(array[index]);
        node.left = buildTree(array, 2 * index + 1);
        node.right = buildTree(array, 2 * index + 2);

        return node;
    }

}