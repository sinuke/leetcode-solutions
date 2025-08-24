package com.sinuke.easy;

import com.sinuke.common.data.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.sinuke.common.data.TreeNode.buildTree;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RangeSumOfBSTTest {

    @ParameterizedTest
    @MethodSource("testData")
    void rangeSumBST(TreeNode root, int low, int high, int expected) {
        var solution = new RangeSumOfBST();
        assertEquals(expected, solution.rangeSumBST(root, low, high));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildTree(new Integer[]{10,5,15,3,7,null,18}), 7, 15, 32),
                Arguments.of(buildTree(new Integer[]{10,5,15,3,7,13,18,1,null,6}), 6, 10, 23)
        );
    }

}