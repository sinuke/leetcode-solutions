package com.sinuke.medium;

import com.sinuke.common.data.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.sinuke.common.data.TreeNode.buildTree;
import static org.junit.jupiter.api.Assertions.assertEquals;

class KthSmallestElementInBSTTest {

    @ParameterizedTest
    @MethodSource("testData")
    void kthSmallest(TreeNode root, int k, int expected) {
        var solution = new KthSmallestElementInBST();
        assertEquals(expected, solution.kthSmallest(root, k));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildTree(new Integer[]{3,1,4,null,2}), 1, 1),
                Arguments.of(buildTree(new Integer[] {5,3,6,2,4,null,null,1}), 3, 3)
        );
    }

}
