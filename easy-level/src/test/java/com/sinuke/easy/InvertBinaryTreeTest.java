package com.sinuke.easy;

import com.sinuke.common.data.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.sinuke.common.data.TreeNode.buildTree;
import static com.sinuke.common.data.TreeNode.toArray;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class InvertBinaryTreeTest {

    @ParameterizedTest
    @MethodSource("testData")
    void invertTree(TreeNode root, TreeNode expected) {
        var solution = new InvertBinaryTree();
        assertArrayEquals(toArray(expected), toArray(solution.invertTree(root)));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildTree(new Integer[]{4,2,7,1,3,6,9}), buildTree(new Integer[] {4,7,2,9,6,3,1})),
                Arguments.of(buildTree(new Integer[]{2,1,3}), buildTree(new Integer[] {2,3,1})),
                Arguments.of(buildTree(new Integer[]{}), buildTree(new Integer[] {}))
        );
    }

}
