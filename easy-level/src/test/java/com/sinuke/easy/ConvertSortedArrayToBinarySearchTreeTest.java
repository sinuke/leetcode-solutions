package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConvertSortedArrayToBinarySearchTreeTest {

    @ParameterizedTest
    @MethodSource("testData")
    void sortedArrayToBST(int[] nums, ConvertSortedArrayToBinarySearchTree.TreeNode expected) {
        var solution = new ConvertSortedArrayToBinarySearchTree();
        var actual = solution.sortedArrayToBST(nums);
        assertEquals(expected.val, actual.val);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {-10,-3,0,5,9}, new ConvertSortedArrayToBinarySearchTree.TreeNode(0)),
                Arguments.of(new int[] {1, 3}, new ConvertSortedArrayToBinarySearchTree.TreeNode(1))
        );
    }

}
