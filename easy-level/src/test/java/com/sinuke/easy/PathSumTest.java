package com.sinuke.easy;

import com.sinuke.common.data.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.sinuke.common.data.TreeNode.buildTree;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PathSumTest {

    @ParameterizedTest
    @MethodSource("testData")
    void hasPathSum(TreeNode root, int targetSum, boolean expected) {
        var solution = new PathSum();
        assertEquals(expected, solution.hasPathSum(root, targetSum));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildTree(new Integer[] {5,4,8,11,null,13,4,7,2,null,null,null,1}), 22, true),
                Arguments.of(buildTree(new Integer[] {1,2,3}), 5, false),
                Arguments.of(buildTree(new Integer[] {}), 0, false)
        );
    }

}
