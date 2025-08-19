package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PathSumIITest {

    @ParameterizedTest
    @MethodSource("testData")
    void pathSum(PathSumII.TreeNode root, int targetSum, List<List<Integer>> expected) {
        var solution = new PathSumII();

        var actual = solution.pathSum(root, targetSum);

        var expectedSet = new HashSet<Set<Integer>>();
        expected.forEach(n -> expectedSet.add(new HashSet<>(n)));

        assertEquals(expected.size(), actual.size());
        actual.forEach(a -> assertTrue(expectedSet.contains(new HashSet<>(a))));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildTree(new Integer[] {5,4,8,11,null,13,4,7,2,null,null,5,1}), 22, List.of(List.of(5,4,11,2), List.of(5,8,4,5))),
                Arguments.of(buildTree(new Integer[] {1,2,3}), 5, List.of()),
                Arguments.of(buildTree(new Integer[] {1,2}), 0, List.of())
        );
    }

    private static PathSumII.TreeNode buildTree(Integer[] array) {
        if (array == null || array.length == 0) return null;

        var root = new PathSumII.TreeNode(array[0]);
        Queue<PathSumII.TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (i < array.length && !queue.isEmpty()) {
            var current = queue.poll();

            if (array[i] != null) {
                current.left = new PathSumII.TreeNode(array[i]);
                queue.offer(current.left);
            }
            i++;

            if (i < array.length && array[i] != null) {
                current.right = new PathSumII.TreeNode(array[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

}
