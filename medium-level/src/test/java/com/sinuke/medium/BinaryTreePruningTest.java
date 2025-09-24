package com.sinuke.medium;

import com.sinuke.common.data.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.sinuke.common.data.TreeNode.buildTree;
import static com.sinuke.common.data.TreeNode.toArray;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class BinaryTreePruningTest {

    @ParameterizedTest
    @MethodSource("testData")
    void pruneTree(TreeNode root, TreeNode expected) {
        var solution = new BinaryTreePruning();
        assertArrayEquals(toArray(expected), toArray(solution.pruneTree(root)));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildTree(new Integer[]{1,null,0,0,1}), buildTree(new Integer[]{1,null,0,null,1})),
                Arguments.of(buildTree(new Integer[]{1,0,1,0,0,0,1}), buildTree(new Integer[]{1,null,1,null,1})),
                Arguments.of(buildTree(new Integer[]{1,1,0,1,1,0,1,0}), buildTree(new Integer[]{1,1,0,1,1,null,1}))
        );
    }

}
