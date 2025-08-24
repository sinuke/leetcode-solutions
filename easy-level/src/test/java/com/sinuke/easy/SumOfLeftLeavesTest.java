package com.sinuke.easy;

import com.sinuke.common.data.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.sinuke.common.data.TreeNode.buildTree;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SumOfLeftLeavesTest {

    @ParameterizedTest
    @MethodSource("testData")
    void sumOfLeftLeaves(TreeNode root, int expected) {
        var solution = new SumOfLeftLeaves();
        assertEquals(expected, solution.sumOfLeftLeaves2(root));
        assertEquals(expected, solution.sumOfLeftLeaves(root));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildTree(new Integer[]{3,9,20,null,null,15,7}), 24),
                Arguments.of(buildTree(new Integer[]{1}), 0),
                Arguments.of(buildTree(new Integer[]{3,4,5,-7,-6,null,null,-7,null,-5,null,null,null,-4}), -11)
        );
    }

}
