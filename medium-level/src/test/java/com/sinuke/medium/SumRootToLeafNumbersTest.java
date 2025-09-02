package com.sinuke.medium;

import com.sinuke.common.data.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.sinuke.common.data.TreeNode.buildTree;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SumRootToLeafNumbersTest {

    @ParameterizedTest
    @MethodSource("testData")
    void sumNumbers(TreeNode root, int expected) {
        var solution = new SumRootToLeafNumbers();
        assertEquals(expected, solution.sumNumbers(root));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildTree(new Integer[] {1,2,3}), 25),
                Arguments.of(buildTree(new Integer[] {4,9,0,5,1}), 1026)
        );
    }

}
