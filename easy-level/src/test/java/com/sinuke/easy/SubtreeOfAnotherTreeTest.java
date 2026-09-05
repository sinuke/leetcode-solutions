package com.sinuke.easy;

import com.sinuke.common.data.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.sinuke.common.data.TreeNode.buildTree;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SubtreeOfAnotherTreeTest {

    @ParameterizedTest
    @MethodSource("testData")
    void isSubtree(TreeNode root, TreeNode subRoot, boolean expected) {
        var solution = new SubtreeOfAnotherTree();
        assertEquals(expected, solution.isSubtree(root, subRoot));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildTree(new Integer[]{3, 4, 5, 1, 2}), buildTree(new Integer[]{4, 1, 2}), true),
                Arguments.of(buildTree(new Integer[]{3, 4, 5, 1, 2, null, null, null, null, 0}), buildTree(new Integer[]{4, 1, 2}), false)
        );
    }

}
