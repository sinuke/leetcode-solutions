package com.sinuke.easy;

import com.sinuke.common.data.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.sinuke.common.data.TreeNode.buildTree;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumDepthOfBinaryTreeTest {

    @ParameterizedTest
    @MethodSource("testData")
    void minDepth(TreeNode root, int expected) {
        var solution = new MinimumDepthOfBinaryTree();
        assertEquals(expected, solution.minDepth(root));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildTree(new Integer[] {3,9,20,null,null,15,7}), 2),
                Arguments.of(buildTree(new Integer[] {2,null,3,null,4,null,5,null,6}), 5),
                Arguments.of(buildTree(new Integer[] {}), 0)
        );
    }

}
