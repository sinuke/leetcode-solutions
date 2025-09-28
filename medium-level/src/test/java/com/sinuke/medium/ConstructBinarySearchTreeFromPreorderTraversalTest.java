package com.sinuke.medium;

import com.sinuke.common.data.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.sinuke.common.data.TreeNode.buildTree;
import static com.sinuke.common.data.TreeNode.toArray;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ConstructBinarySearchTreeFromPreorderTraversalTest {

    @ParameterizedTest
    @MethodSource("testData")
    void bstFromPreorder(int[] preorder, TreeNode expected) {
        var solution = new ConstructBinarySearchTreeFromPreorderTraversal();
        assertArrayEquals(toArray(expected), toArray(solution.bstFromPreorder(preorder)));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {8,5,1,7,10,12}, buildTree(new Integer[]{8,5,10,1,7,null,12})),
                Arguments.of(new int[] {1,3}, buildTree(new Integer[]{1,null,3}))
        );
    }

}
