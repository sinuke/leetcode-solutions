package com.sinuke.easy;

import com.sinuke.common.data.Node;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.sinuke.common.data.Node.buildTree;
import static org.junit.jupiter.api.Assertions.assertEquals;

class NaryTreePostorderTraversalTest {

    @ParameterizedTest
    @MethodSource("testData")
    void postorder(Node root, List<Integer> expected) {
        var solution = new NaryTreePostorderTraversal();
        assertEquals(expected, solution.postorder(root));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildTree(new Integer[]{1,null,3,2,4,null,5,6}), List.of(5,6,3,2,4,1)),
                Arguments.of(buildTree(new Integer[]{1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14}), List.of(2,6,14,11,7,3,12,8,4,13,9,10,5,1))
        );
    }

}
