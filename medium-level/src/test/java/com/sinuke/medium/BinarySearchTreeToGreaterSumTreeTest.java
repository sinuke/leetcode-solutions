package com.sinuke.medium;

import com.sinuke.common.data.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.sinuke.common.data.TreeNode.buildTree;
import static com.sinuke.common.data.TreeNode.toArray;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class BinarySearchTreeToGreaterSumTreeTest {

    @ParameterizedTest
    @MethodSource("testData")
    void bstToGst(TreeNode root, TreeNode expected) {
        var solution = new BinarySearchTreeToGreaterSumTree();
        assertArrayEquals(toArray(expected), toArray(solution.bstToGst(root)));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildTree(new Integer[]{4,1,6,0,2,5,7,null,null,null,3,null,null,null,8}), buildTree(new Integer[]{30,36,21,36,35,26,15,null,null,null,33,null,null,null,8})),
                Arguments.of(buildTree(new Integer[]{0,null,1}), buildTree(new Integer[]{1,null,1}))
        );
    }

}
