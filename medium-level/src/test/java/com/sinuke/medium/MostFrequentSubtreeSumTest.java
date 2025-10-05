package com.sinuke.medium;

import com.sinuke.common.data.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.sinuke.common.data.TreeNode.buildTree;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MostFrequentSubtreeSumTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findFrequentTreeSum(TreeNode root, int[] expected) {
        var solution = new MostFrequentSubtreeSum();
        assertArrayEquals(expected,solution.findFrequentTreeSum(root));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildTree(new Integer[]{5,2,-3}), new int[] {2,-3,4}),
                Arguments.of(buildTree(new Integer[]{5,2,-5}), new int[] {2})
        );
    }

}
