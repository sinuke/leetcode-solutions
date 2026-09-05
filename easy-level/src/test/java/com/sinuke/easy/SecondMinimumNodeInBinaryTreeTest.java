package com.sinuke.easy;

import com.sinuke.common.data.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.sinuke.common.data.TreeNode.buildTree;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SecondMinimumNodeInBinaryTreeTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findSecondMinimumValue(TreeNode root, int expected) {
        var solution = new SecondMinimumNodeInBinaryTree();
        assertEquals(expected, solution.findSecondMinimumValue(root));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildTree(new Integer[]{2, 2, 5, null, null, 5, 7}), 5),
                Arguments.of(buildTree(new Integer[]{2, 2, 2}), -1)
        );
    }

}
