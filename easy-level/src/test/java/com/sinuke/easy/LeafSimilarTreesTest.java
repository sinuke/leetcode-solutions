package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LeafSimilarTreesTest {

    @ParameterizedTest
    @MethodSource("testData")
    void leafSimilar(LeafSimilarTrees.TreeNode root1, LeafSimilarTrees.TreeNode root2, boolean expected) {
        var solution = new LeafSimilarTrees();
        assertEquals(expected, solution.leafSimilar(root1, root2));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildTree(new Integer[]{3,5,1,6,2,9,8,null,null,7,4}), buildTree(new Integer[]{3,5,1,6,7,4,2,null,null,null,null,null,null,9,8}), true),
                Arguments.of(buildTree(new Integer[]{1,2,3}), buildTree(new Integer[]{1,3,2}), false)
        );
    }

    private static LeafSimilarTrees.TreeNode buildTree(Integer[] array) {
        if (array == null || array.length == 0) return null;

        var root = new LeafSimilarTrees.TreeNode(array[0]);
        Queue<LeafSimilarTrees.TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (i < array.length && !queue.isEmpty()) {
            var current = queue.poll();

            if (array[i] != null) {
                current.left = new LeafSimilarTrees.TreeNode(array[i]);
                queue.offer(current.left);
            }
            i++;

            if (i < array.length && array[i] != null) {
                current.right = new LeafSimilarTrees.TreeNode(array[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

}
