package com.sinuke.medium;

import com.sinuke.common.data.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.sinuke.common.data.TreeNode.buildTree;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidateBinarySearchTreeTest {

    @ParameterizedTest
    @MethodSource("testData")
    void isValidBST(TreeNode root, boolean expected) {
        var solution = new ValidateBinarySearchTree();
        assertEquals(expected, solution.isValidBST(root));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildTree(new Integer[]{2,1,3}), true),
                Arguments.of(buildTree(new Integer[]{5,1,4,null,null,3,6}), false),
                Arguments.of(buildTree(new Integer[]{2,null,3}), true),
                Arguments.of(buildTree(new Integer[]{5,4,6,null,null,3,7}), false)
        );
    }

}
