package com.sinuke.easy;

import com.sinuke.common.data.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.sinuke.common.data.TreeNode.buildTree;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CousinsInBinaryTreeTest {

    @ParameterizedTest
    @MethodSource("testData")
    void isCousins(TreeNode root, int x, int y, boolean expected) {
        var solution = new CousinsInBinaryTree();
        assertEquals(expected, solution.isCousins(root, x, y));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildTree(new Integer[]{1, 2, 3, 4}), 4, 3, false),
                Arguments.of(buildTree(new Integer[]{1, 2, 3, null, 4, null, 5}), 5, 4, true),
                Arguments.of(buildTree(new Integer[]{1, 2, 3, null, 4}), 2, 3, false)
        );
    }

}
