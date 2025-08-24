package com.sinuke.easy;

import com.sinuke.common.data.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountCompleteTreeNodesTest {

    @ParameterizedTest
    @MethodSource("testData")
    void countNodes(TreeNode root, int expected) {
        var solution = new CountCompleteTreeNodes();
        assertEquals(expected, solution.countNodes(root));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildFirstTestCase(), 6),
                Arguments.of(null, 0),
                Arguments.of(new TreeNode(1), 1)
        );
    }

    private static TreeNode buildFirstTestCase() {
        var n2  = new TreeNode(2);
        n2.left = new TreeNode(4);
        n2.right = new TreeNode(5);

        var n3  = new TreeNode(3);
        n3.left = new TreeNode(6);

        var root = new TreeNode(1);
        root.left = n2;
        root.right = n3;

        return  root;
    }

}
