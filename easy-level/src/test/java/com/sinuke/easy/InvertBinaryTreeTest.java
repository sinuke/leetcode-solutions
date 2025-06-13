package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class InvertBinaryTreeTest {

    @ParameterizedTest
    @MethodSource("testData")
    void invertTree(InvertBinaryTree.TreeNode root, InvertBinaryTree.TreeNode expected) {
        var solution = new InvertBinaryTree();
        assertArrayEquals(toArray(expected), toArray(solution.invertTree(root)));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildTree(new Integer[]{4,2,7,1,3,6,9}), buildTree(new Integer[] {4,7,2,9,6,3,1})),
                Arguments.of(buildTree(new Integer[]{2,1,3}), buildTree(new Integer[] {2,3,1})),
                Arguments.of(buildTree(new Integer[]{}), buildTree(new Integer[] {}))
        );
    }

    public static InvertBinaryTree.TreeNode buildTree(Integer[] array) {
        if (array == null || array.length == 0) return null;
        return buildTree(array, 0);
    }

    private static InvertBinaryTree.TreeNode buildTree(Integer[] array, int index) {
        if (index >= array.length || array[index] == null) return null;

        var node = new InvertBinaryTree.TreeNode(array[index]);
        node.left = buildTree(array, 2 * index + 1);
        node.right = buildTree(array, 2 * index + 2);

        return node;
    }

    private int[] toArray(InvertBinaryTree.TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root != null) {
            list.add(root.val);
            for (int val : toArray(root.left)) list.add(val);
            for (int val : toArray(root.right)) list.add(val);
        }
        return list.stream().mapToInt(x -> x).toArray();
    }

}
