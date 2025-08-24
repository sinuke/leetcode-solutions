package com.sinuke.easy;

import com.sinuke.common.data.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.sinuke.common.data.TreeNode.buildTree;
import static com.sinuke.common.data.TreeNode.toArray;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SearchInBinarySearchTreeTest {

    @ParameterizedTest
    @MethodSource("testData")
    void searchBST(TreeNode root, int val, TreeNode expected) {
        var solution = new SearchInBinarySearchTree();
        var result = solution.searchBST(root, val);
        assertArrayEquals(toArray(expected), toArray(result));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildTree(new Integer[] {4,2,7,1,3}), 2, buildTree(new Integer[] {2,1,3})),
                Arguments.of(buildTree(new Integer[] {4,2,7,1,3}), 5, buildTree(new Integer[] {}))
        );
    }

}
