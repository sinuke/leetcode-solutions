package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryTreePathsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void binaryTreePaths(BinaryTreePaths.TreeNode root, List<String> expected) {
        var solution = new BinaryTreePaths();
        assertEquals(expected, solution.binaryTreePaths(root));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(firstTest(), List.of("1->2->5","1->3")),
                Arguments.of(new BinaryTreePaths.TreeNode(1), List.of("1"))
        );
    }

    private static BinaryTreePaths.TreeNode firstTest() {
        var node5 = new BinaryTreePaths.TreeNode(5);
        var node2 = new BinaryTreePaths.TreeNode(2, null, node5);
        return new BinaryTreePaths.TreeNode(1, node2, new  BinaryTreePaths.TreeNode(3));
    }

}
