package com.sinuke.easy;

import com.sinuke.common.data.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.sinuke.common.data.TreeNode.buildTree;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SymmetricTreeTest {

    @ParameterizedTest
    @MethodSource("testData")
    void isSymmetric(TreeNode root, boolean expected) {
        var solution = new SymmetricTree();
        assertEquals(expected, solution.isSymmetric(root));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildTree(new Integer[] {1,2,2,3,4,4,3}), true),
                Arguments.of(buildTree(new Integer[] {1,2,2,null,3,null,3}), false)
        );
    }

}
