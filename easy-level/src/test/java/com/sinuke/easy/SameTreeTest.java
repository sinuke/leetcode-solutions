package com.sinuke.easy;

import com.sinuke.common.data.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.sinuke.common.data.TreeNode.buildTree;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SameTreeTest {

    @ParameterizedTest
    @MethodSource("testData")
    void isSameTree(TreeNode p, TreeNode q, boolean expected) {
        var solution = new SameTree();
        assertEquals(expected, solution.isSameTree(p, q));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildTree(new Integer[] {1,2,3}), buildTree(new Integer[]{1,2,3}), true),
                Arguments.of(buildTree(new Integer[] {1,2}), buildTree(new Integer[]{1,null,2}), false),
                Arguments.of(buildTree(new Integer[] {1,2,1}), buildTree(new Integer[]{1,1,2}), false)
        );
    }

}
