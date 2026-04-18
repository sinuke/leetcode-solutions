package com.sinuke.easy;

import com.sinuke.common.data.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.sinuke.common.data.TreeNode.buildTree;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DiameterOfBinaryTreeTest {

    @ParameterizedTest
    @MethodSource("testData")
    void diameterOfBinaryTree(TreeNode root, int expected) {
        assertEquals(expected, new DiameterOfBinaryTree().diameterOfBinaryTree(root));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildTree(new Integer[]{1, 2, 3, 4, 5}), 3),
                Arguments.of(buildTree(new Integer[]{1, 2}), 1)
        );
    }

}
