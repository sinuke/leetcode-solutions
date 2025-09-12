package com.sinuke.medium;

import com.sinuke.common.data.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.sinuke.common.data.TreeNode.buildTree;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DeepestLeavesSumTest {

    @ParameterizedTest
    @MethodSource("testData")
    void deepestLeavesSum(TreeNode root, int expected) {
        var solution = new DeepestLeavesSum();
        assertEquals(expected, solution.deepestLeavesSum(root));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildTree(new Integer[] {1,2,3,4,5,null,6,7,null,null,null,null,8}), 15),
                Arguments.of(buildTree(new Integer[] {6,7,8,2,7,1,3,9,null,1,4,null,null,null,5}), 19),
                Arguments.of(buildTree(new Integer[] {38,43,70,16,null,78,91,null,71,27,null,71,null,null,null,71}), 71)
        );
    }

}
