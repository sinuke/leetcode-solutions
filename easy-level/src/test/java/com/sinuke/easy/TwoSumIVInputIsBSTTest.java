package com.sinuke.easy;

import com.sinuke.common.data.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TwoSumIVInputIsBSTTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findTarget(TreeNode root, int k, boolean expected) {
        assertEquals(expected, new TwoSumIVInputIsBST().findTarget(root, k));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildTree(), 9, true),
                Arguments.of(buildTree(), 28, false)
        );
    }

    private static TreeNode buildTree() {
        var node2 = new TreeNode(2);
        var node4 = new TreeNode(4);
        var node7 = new TreeNode(7);
        var node3 = new TreeNode(3, node2, node4);
        var node6 = new TreeNode(6, null, node7);
        return new TreeNode(5, node3, node6);
    }

}
