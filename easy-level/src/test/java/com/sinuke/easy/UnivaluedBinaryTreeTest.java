package com.sinuke.easy;

import com.sinuke.common.data.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.sinuke.common.data.TreeNode.buildTree;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UnivaluedBinaryTreeTest {

    @ParameterizedTest
    @MethodSource("testData")
    void isUnivalTree(TreeNode root, boolean expected) {
        var solution = new UnivaluedBinaryTree();
        assertEquals(expected, solution.isUnivalTree(root));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildTree(new Integer[]{1,1,1,1,1,null,1}), true),
                Arguments.of(buildTree(new Integer[]{2,2,2,5,2}), false)
        );
    }

}
