package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RootEqualsSumOfChildrenTest {

    @ParameterizedTest
    @MethodSource("testData")
    void checkTree(RootEqualsSumOfChildren.TreeNode root, boolean expected) {
        var solution = new RootEqualsSumOfChildren();
        assertEquals(expected, solution.checkTree(root));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildTree(new Integer[] {10, 4, 6}), true),
                Arguments.of(buildTree(new Integer[] {5,3,1}), false)
        );
    }

    public static RootEqualsSumOfChildren.TreeNode buildTree(Integer[] array) {
        if (array == null || array.length == 0) return null;
        return buildTree(array, 0);
    }

    private static RootEqualsSumOfChildren.TreeNode buildTree(Integer[] array, int index) {
        if (index >= array.length || array[index] == null) return null;

        var node = new RootEqualsSumOfChildren.TreeNode(array[index]);
        node.left = buildTree(array, 2 * index + 1);
        node.right = buildTree(array, 2 * index + 2);

        return node;
    }

}