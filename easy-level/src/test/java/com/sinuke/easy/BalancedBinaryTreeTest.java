package com.sinuke.easy;

import com.sinuke.common.data.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.sinuke.common.data.TreeNode.buildTree;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BalancedBinaryTreeTest {

    @ParameterizedTest
    @MethodSource("testData")
    void isBalanced(TreeNode root, boolean expected) {
        var solution = new BalancedBinaryTree();
        assertEquals(expected, solution.isBalanced(root));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildTree(new Integer[] {3,9,20,null,null,15,7}), true),
                Arguments.of(buildTree(new Integer[] {1,2,2,3,3,null,null,4,4}), false),
                Arguments.of(buildTree(new Integer[] {}), true)
        );
    }

}
