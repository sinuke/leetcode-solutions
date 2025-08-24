package com.sinuke.easy;

import com.sinuke.common.data.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.sinuke.common.data.TreeNode.buildTree;
import static com.sinuke.common.data.TreeNode.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class IncreasingOrderSearchTreeTest {

    @ParameterizedTest
    @MethodSource("testData")
    void increasingBST(TreeNode root, TreeNode expected) {
        var solution = new IncreasingOrderSearchTree();
        var result = solution.increasingBST(root);
        assertEquals(toList(expected), toList(result));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildTree(new Integer[] {5,3,6,2,4,null,8,1,null,null,null,7,9}), buildTree(new Integer[] {1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9})),
                Arguments.of(buildTree(new Integer[] {5,1,7}), buildTree(new Integer[] {1,null,5,null,7}))
        );
    }

}
