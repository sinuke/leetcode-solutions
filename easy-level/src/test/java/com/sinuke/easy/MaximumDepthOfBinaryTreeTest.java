package com.sinuke.easy;

import com.sinuke.common.data.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.sinuke.common.data.TreeNode.buildTree;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumDepthOfBinaryTreeTest {

    @ParameterizedTest
    @MethodSource("testData")
    void maxDepth(TreeNode root, int expected) {
        var solution = new MaximumDepthOfBinaryTree();
        assertEquals(expected, solution.maxDepth(root));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildTree(new Integer[]{3,9,20,null,null,15,7}), 3),
                Arguments.of(buildTree(new Integer[]{1,null,2}), 2)
        );
    }

}
