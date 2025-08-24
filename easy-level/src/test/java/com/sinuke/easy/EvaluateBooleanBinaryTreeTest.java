package com.sinuke.easy;

import com.sinuke.common.data.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.sinuke.common.data.TreeNode.buildTree;
import static org.junit.jupiter.api.Assertions.assertEquals;

class EvaluateBooleanBinaryTreeTest {

    @ParameterizedTest
    @MethodSource("testData")
    void evaluateTree(TreeNode root, boolean expected) {
        var solution = new EvaluateBooleanBinaryTree();
        assertEquals(expected, solution.evaluateTree(root));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildTree(new Integer[]{2,1,3,null,null,0,1}), true),
                Arguments.of(buildTree(new Integer[]{0}), false)
        );
    }

}
