package com.sinuke.medium;

import com.sinuke.common.data.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.sinuke.common.data.ListNode.buildList;
import static com.sinuke.common.data.ListNode.toArray;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SwapNodesInPairsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void swapPairs(ListNode head, ListNode expected) {
        var solution = new SwapNodesInPairs();
        assertArrayEquals(toArray(expected), toArray(solution.swapPairs(head)));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildList(1,2,3,4), buildList(2,1,4,3)),
                Arguments.of(buildList(), buildList()),
                Arguments.of(buildList(1), buildList(1)),
                Arguments.of(buildList(1,2,3), buildList(2,1,3)),
                Arguments.of(buildList(1,2,3,4,5,6,7), buildList(2,1,4,3,6,5,7))
        );
    }

}