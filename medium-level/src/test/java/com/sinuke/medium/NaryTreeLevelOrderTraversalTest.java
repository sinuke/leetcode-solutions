package com.sinuke.medium;

import com.sinuke.common.data.Node;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.sinuke.common.data.Node.buildTree;
import static org.junit.jupiter.api.Assertions.assertEquals;

class NaryTreeLevelOrderTraversalTest {

    @ParameterizedTest
    @MethodSource("testData")
    void levelOrder(Node root, List<List<Integer>> expected) {
        var solution = new NaryTreeLevelOrderTraversal();
        assertEquals(expected, solution.levelOrder(root));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildTree(new Integer[] {1,null,3,2,4,null,5,6}), List.of(List.of(1), List.of(3,2,4), List.of(5,6))),
                Arguments.of(buildTree(new Integer[] {1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14}), List.of(List.of(1), List.of(2,3,4,5), List.of(6,7,8,9,10), List.of(11,12,13), List.of(14)))
        );
    }

}
