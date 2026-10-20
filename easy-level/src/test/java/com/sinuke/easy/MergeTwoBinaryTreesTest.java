package com.sinuke.easy;

import com.sinuke.common.data.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.sinuke.common.data.TreeNode.buildTree;
import static com.sinuke.common.data.TreeNode.toArray;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MergeTwoBinaryTreesTest {

    @ParameterizedTest
    @MethodSource("testData")
    void mergeTrees(TreeNode root1, TreeNode root2, TreeNode expected) {
        var solution = new MergeTwoBinaryTrees();
        assertArrayEquals(toArray(expected), toArray(solution.mergeTrees(root1, root2)));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildTree(new Integer[]{1,3,2,5}), buildTree(new Integer[]{2,1,3,null,4,null,7}), buildTree(new Integer[]{3,4,5,5,4,null,7})),
                Arguments.of(buildTree(new Integer[]{1}), buildTree(new Integer[]{1,2}), buildTree(new Integer[]{2,2}))
        );
    }

}
