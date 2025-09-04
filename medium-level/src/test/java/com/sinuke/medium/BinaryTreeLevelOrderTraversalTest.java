package com.sinuke.medium;

import com.sinuke.common.data.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.sinuke.common.data.TreeNode.buildTree;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryTreeLevelOrderTraversalTest {

    @ParameterizedTest
    @MethodSource("testData")
    void levelOrder(TreeNode root, List<List<Integer>> expected) {
        var solution = new BinaryTreeLevelOrderTraversal();
        assertEquals(expected, solution.levelOrder(root));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildTree(new Integer[]{3,9,20,null,null,15,7}), List.of(List.of(3), List.of(9, 20), List.of(15, 7))),
                Arguments.of(buildTree(new Integer[]{1}), List.of(List.of(1))),
                Arguments.of(buildTree(new Integer[]{}), List.of())
        );
    }

}
