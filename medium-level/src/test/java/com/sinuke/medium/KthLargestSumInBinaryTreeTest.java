package com.sinuke.medium;

import com.sinuke.common.data.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.sinuke.common.data.TreeNode.buildTree;
import static org.junit.jupiter.api.Assertions.assertEquals;

class KthLargestSumInBinaryTreeTest {

    @ParameterizedTest
    @MethodSource("testData")
    void kthLargestLevelSum(TreeNode treeNode, int k, int expected) {
        var solution = new KthLargestSumInBinaryTree();
        assertEquals(expected, solution.kthLargestLevelSum(treeNode, k));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildTree(new Integer[]{5,8,9,2,1,3,7,4,6}), 2, 13),
                Arguments.of(buildTree(new Integer[]{5,8,9,2,1,3,7}), 4, -1),
                Arguments.of(buildTree(new Integer[]{1,1}), 2, 1),
                Arguments.of(buildTree(new Integer[]{1,2,null,3}), 1, 3)
        );
    }

}
