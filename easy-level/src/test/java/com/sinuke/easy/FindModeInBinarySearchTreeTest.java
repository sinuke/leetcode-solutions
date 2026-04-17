package com.sinuke.easy;

import com.sinuke.common.data.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static com.sinuke.common.data.TreeNode.buildTree;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class FindModeInBinarySearchTreeTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findMode(TreeNode root, int[] expected) {
        var actual = new FindModeInBinarySearchTree().findMode(root);
        Arrays.sort(actual);
        Arrays.sort(expected);
        assertArrayEquals(expected, actual);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildTree(new Integer[]{1, null, 2, 2}), new int[]{2}),
                Arguments.of(buildTree(new Integer[]{0}), new int[]{0})
        );
    }

}
