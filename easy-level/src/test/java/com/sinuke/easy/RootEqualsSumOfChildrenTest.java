package com.sinuke.easy;

import com.sinuke.common.data.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.sinuke.common.data.TreeNode.buildTree;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RootEqualsSumOfChildrenTest {

    @ParameterizedTest
    @MethodSource("testData")
    void checkTree(TreeNode root, boolean expected) {
        var solution = new RootEqualsSumOfChildren();
        assertEquals(expected, solution.checkTree(root));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildTree(new Integer[] {10, 4, 6}), true),
                Arguments.of(buildTree(new Integer[] {5,3,1}), false)
        );
    }

}