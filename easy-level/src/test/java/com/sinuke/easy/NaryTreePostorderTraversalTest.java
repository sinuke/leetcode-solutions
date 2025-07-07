package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NaryTreePostorderTraversalTest {

    @ParameterizedTest
    @MethodSource("testData")
    void postorder(NaryTreePostorderTraversal.Node root, List<Integer> expected) {
        var solution = new NaryTreePostorderTraversal();
        assertEquals(expected, solution.postorder(root));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildTree(new Integer[]{1,null,3,2,4,null,5,6}), List.of(5,6,3,2,4,1)),
                Arguments.of(buildTree(new Integer[]{1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14}), List.of(2,6,14,11,7,3,12,8,4,13,9,10,5,1))
        );
    }

    private static NaryTreePostorderTraversal.Node buildTree(Integer[] array) {
        if (array == null || array.length == 0) return null;

        Deque<NaryTreePostorderTraversal.Node> queue = new LinkedList<>();
        var root = new NaryTreePostorderTraversal.Node(array[0], new ArrayList<>());
        queue.add(root);

        for (int i = 1; i < array.length; i++) {
            if (array[i] != null)  {
                var node = new NaryTreePostorderTraversal.Node(array[i], new ArrayList<>());
                if (!queue.isEmpty()) queue.peekFirst().children.add(node);
                queue.offer(node);

                if (i + 1 < array.length && array[i + 1] == null) queue.pollFirst();
            } else if (i + 1 < array.length && array[i + 1] == null) queue.pollFirst();
        }

        return root;
    }

}
