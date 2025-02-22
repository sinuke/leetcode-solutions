package com.sinuke.hard;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RecoverTreeFromPreorderTraversalTest {

    @ParameterizedTest
    @MethodSource("testData")
    void recoverFromPreorder(String traversal, List<Integer> expected) {
        var solution = new RecoverTreeFromPreorderTraversal();
        List<Integer> actual = levelOrderTraversal(solution.recoverFromPreorder(traversal));
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("1-2--3--4-5--6--7", Arrays.asList(1, 2, 5, 3, 4, 6, 7)),
                Arguments.of("1-2--3---4-5--6---7", Arrays.asList(1,2,5,3,null,6,null,4,null,7)),
                Arguments.of("1-401--349---90--88", Arrays.asList(1,401,null,349,88,90))
        );
    }

    public List<Integer> levelOrderTraversal(RecoverTreeFromPreorderTraversal.TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<RecoverTreeFromPreorderTraversal.TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            var node = queue.poll();
            if (node != null) {
                result.add(node.val);
                if (node.left != null || node.right != null) {
                    queue.add(node.left);
                    queue.add(node.right);
                }
            } else result.add(null);
        }

        if (result.getLast() == null) result.removeLast();
        return result;
    }

}
