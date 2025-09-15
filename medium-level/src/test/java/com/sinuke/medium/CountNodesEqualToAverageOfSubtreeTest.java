package com.sinuke.medium;

import com.sinuke.common.data.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.sinuke.common.data.TreeNode.buildTree;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CountNodesEqualToAverageOfSubtreeTest {

    @ParameterizedTest
    @MethodSource("testData")
    void averageOfSubtree(TreeNode root, int expected) {
        var solution = new CountNodesEqualToAverageOfSubtree();
        assertEquals(expected, solution.averageOfSubtree(root));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildTree(new Integer[] {4,8,5,0,1,null,6}), 5),
                Arguments.of(buildTree(new Integer[] {1}), 1)
        );
    }

}
