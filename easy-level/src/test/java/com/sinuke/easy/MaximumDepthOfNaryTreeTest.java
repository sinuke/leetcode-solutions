package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumDepthOfNaryTreeTest {

    @ParameterizedTest
    @MethodSource("testData")
    void maxDepth(MaximumDepthOfNaryTree.Node root, int expected) {
        var solution =  new MaximumDepthOfNaryTree();
        assertEquals(expected, solution.maxDepth(root));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(getFirstTestCase(), 3),
                Arguments.of(getSecondTestCase(), 5)
        );
    }

    private static MaximumDepthOfNaryTree.Node getFirstTestCase() {
        var n3 = new MaximumDepthOfNaryTree.Node(3, List.of(new MaximumDepthOfNaryTree.Node(5, List.of()), new MaximumDepthOfNaryTree.Node(6, List.of())));
        return new MaximumDepthOfNaryTree.Node(1, List.of(n3, new MaximumDepthOfNaryTree.Node(2, List.of()), new MaximumDepthOfNaryTree.Node(4, List.of())));
    }

    private static MaximumDepthOfNaryTree.Node getSecondTestCase() {
        var n11 = new MaximumDepthOfNaryTree.Node(11, List.of(new MaximumDepthOfNaryTree.Node(14, List.of())));
        var n7 = new MaximumDepthOfNaryTree.Node(7, List.of(n11));
        var n3 = new MaximumDepthOfNaryTree.Node(3, List.of(new MaximumDepthOfNaryTree.Node(6, List.of()), n7));
        var n8 = new MaximumDepthOfNaryTree.Node(8, List.of(new MaximumDepthOfNaryTree.Node(12, List.of())));
        var n4 = new MaximumDepthOfNaryTree.Node(4, List.of(n8));
        var n9 =  new MaximumDepthOfNaryTree.Node(9, List.of(new MaximumDepthOfNaryTree.Node(13, List.of())));
        var n5 =  new MaximumDepthOfNaryTree.Node(5, List.of(n9, new MaximumDepthOfNaryTree.Node(10, List.of())));
        return new MaximumDepthOfNaryTree.Node(1, List.of(new MaximumDepthOfNaryTree.Node(2, List.of()), n3, n4, n5));
    }

}
