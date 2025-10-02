package com.sinuke.medium;

import com.sinuke.common.data.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.sinuke.common.data.TreeNode.buildTree;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumLevelSumOfBinaryTreeTest {

    @ParameterizedTest
    @MethodSource("testData")
    void maxLevelSum(TreeNode root, int expected) {
        var solution = new MaximumLevelSumOfBinaryTree();
        assertEquals(expected, solution.maxLevelSum(root));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildTree(new Integer[]{1,7,0,7,-8,null,null}), 2),
                Arguments.of(buildTree(new Integer[]{989,null,10250,98693,-89388,null,null,null,-32127}), 2)
        );
    }

}
