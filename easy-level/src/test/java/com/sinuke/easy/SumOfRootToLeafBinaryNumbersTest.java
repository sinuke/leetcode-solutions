package com.sinuke.easy;

import com.sinuke.common.data.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.sinuke.common.data.TreeNode.buildTree;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SumOfRootToLeafBinaryNumbersTest {

    @ParameterizedTest
    @MethodSource("testData")
    void sumRootToLeaf(TreeNode root, int expected) {
        var solution = new SumOfRootToLeafBinaryNumbers();
        assertEquals(expected, solution.sumRootToLeaf(root));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildTree(new Integer[]{1,0,1,0,1,0,1}), 22),
                Arguments.of(buildTree(new Integer[]{0}), 0)
        );
    }

}
