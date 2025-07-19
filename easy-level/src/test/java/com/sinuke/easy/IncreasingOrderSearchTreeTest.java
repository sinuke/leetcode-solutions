package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IncreasingOrderSearchTreeTest {

    @ParameterizedTest
    @MethodSource("testData")
    void increasingBST(IncreasingOrderSearchTree.TreeNode root, IncreasingOrderSearchTree.TreeNode expected) {
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

    private static IncreasingOrderSearchTree.TreeNode buildTree(Integer[] array) {
        if (array == null || array.length == 0) return null;

        var root = new IncreasingOrderSearchTree.TreeNode(array[0]);
        Queue<IncreasingOrderSearchTree.TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (i < array.length && !queue.isEmpty()) {
            var current = queue.poll();

            if (array[i] != null) {
                current.left = new IncreasingOrderSearchTree.TreeNode(array[i]);
                queue.offer(current.left);
            }
            i++;

            if (i < array.length && array[i] != null) {
                current.right = new IncreasingOrderSearchTree.TreeNode(array[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

    private List<Integer> toList(IncreasingOrderSearchTree.TreeNode root) {
        List<Integer> list = new ArrayList<>();
        doToList(root, list);
        return list;
    }

    private void doToList(IncreasingOrderSearchTree.TreeNode node, List<Integer> list) {
        if (node == null) return;
        list.add(node.val);

        if (node.left == null && node.right != null) {
            list.add(null);
            doToList(node.right, list);
        }
    }

}
