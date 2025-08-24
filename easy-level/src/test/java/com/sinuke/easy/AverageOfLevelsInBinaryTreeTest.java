package com.sinuke.easy;

import com.sinuke.common.data.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.sinuke.common.data.TreeNode.buildTree;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AverageOfLevelsInBinaryTreeTest {

    @ParameterizedTest
    @MethodSource("testData")
    void averageOfLevels(TreeNode root, List<Double> expected) {
        var solution = new AverageOfLevelsInBinaryTree();
        assertEquals(expected, solution.averageOfLevels(root));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildTree(new Integer[]{3,9,20,null,null,15,7}), List.of(3.00000d,14.50000d,11.00000d)),
                Arguments.of(buildTree(new Integer[]{3,9,20,15,7}), List.of(3.00000d,14.50000d,11.00000d)),
                Arguments.of(buildTree(new Integer[]{2147483647,2147483647,2147483647}), List.of(2147483647.00000d,2147483647.00000d))
        );
    }

}
