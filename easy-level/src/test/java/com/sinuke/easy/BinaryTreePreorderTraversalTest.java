package com.sinuke.easy;

import com.sinuke.common.data.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.sinuke.common.data.TreeNode.buildTree;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryTreePreorderTraversalTest {

    @ParameterizedTest
    @MethodSource("testData")
    void preorderTraversal(TreeNode root, List<Integer> expected) {
        var solution = new  BinaryTreePreorderTraversal();
        assertEquals(expected, solution.preorderTraversal(root));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildTree(new Integer[] {1,null,2,3}), List.of(1,2,3)),
                Arguments.of(buildTree(new Integer[] {1,2,3,4,5,null,8,null,null,6,7,9}), List.of(1,2,4,5,6,7,3,8,9)),
                Arguments.of(buildTree(new Integer[] {}), List.of()),
                Arguments.of(buildTree(new Integer[] {1}), List.of(1))
        );
    }

}
