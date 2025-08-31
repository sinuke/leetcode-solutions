package com.sinuke.medium;

import com.sinuke.common.data.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.sinuke.common.data.ListNode.buildList;
import static com.sinuke.common.data.ListNode.toArray;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SwappingNodesInLinkedListTest {

    @ParameterizedTest
    @MethodSource("testData")
    void swapNodes(ListNode head, int k, ListNode expected) {
        var solution = new SwappingNodesInLinkedList();
        assertArrayEquals(toArray(expected), toArray(solution.swapNodes(head, k)));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildList(1,2,3,4,5), 2, buildList(1,4,3,2,5)),
                Arguments.of(buildList(7,9,6,6,7,8,3,0,9,5), 5, buildList(7,9,6,6,8,7,3,0,9,5))
        );
    }

}