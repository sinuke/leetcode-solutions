package com.sinuke.easy;

import com.sinuke.common.data.Node;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumDepthOfNaryTreeTest {

    @ParameterizedTest
    @MethodSource("testData")
    void maxDepth(Node root, int expected) {
        var solution =  new MaximumDepthOfNaryTree();
        assertEquals(expected, solution.maxDepth(root));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(getFirstTestCase(), 3),
                Arguments.of(getSecondTestCase(), 5)
        );
    }

    private static Node getFirstTestCase() {
        var n3 = new Node(3, List.of(new Node(5, List.of()), new Node(6, List.of())));
        return new Node(1, List.of(n3, new Node(2, List.of()), new Node(4, List.of())));
    }

    private static Node getSecondTestCase() {
        var n11 = new Node(11, List.of(new Node(14, List.of())));
        var n7 = new Node(7, List.of(n11));
        var n3 = new Node(3, List.of(new Node(6, List.of()), n7));
        var n8 = new Node(8, List.of(new Node(12, List.of())));
        var n4 = new Node(4, List.of(n8));
        var n9 =  new Node(9, List.of(new Node(13, List.of())));
        var n5 =  new Node(5, List.of(n9, new Node(10, List.of())));
        return new Node(1, List.of(new Node(2, List.of()), n3, n4, n5));
    }

}
