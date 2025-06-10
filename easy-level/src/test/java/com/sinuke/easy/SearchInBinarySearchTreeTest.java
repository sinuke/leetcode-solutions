package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SearchInBinarySearchTreeTest {

    @ParameterizedTest
    @MethodSource("testData")
    void searchBST(SearchInBinarySearchTree.TreeNode root, int val, SearchInBinarySearchTree.TreeNode expected) {
        var solution = new SearchInBinarySearchTree();
        var result = solution.searchBST(root, val);
        assertArrayEquals(toArray(expected), toArray(result));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildTree(new int[] {4,2,7,1,3}), 2, buildTree(new int[] {2,1,3})),
                Arguments.of(buildTree(new int[] {4,2,7,1,3}), 5, buildTree(new int[] {}))
        );
    }

    private static SearchInBinarySearchTree.TreeNode buildTree(int[] array) {
        if (array == null || array.length == 0) return null;
        return buildTree(array, 0);
    }

    private static SearchInBinarySearchTree.TreeNode buildTree(int[] array, int index) {
        if (index >= array.length) return null;

        var node = new SearchInBinarySearchTree.TreeNode(array[index]);
        node.left = buildTree(array, 2 * index + 1);
        node.right = buildTree(array, 2 * index + 2);

        return node;
    }

    private int[] toArray(SearchInBinarySearchTree.TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root != null) {
            list.add(root.val);
            for (int val : toArray(root.left)) list.add(val);
            for (int val : toArray(root.right)) list.add(val);
        }
        return list.stream().mapToInt(x -> x).toArray();
    }

}
