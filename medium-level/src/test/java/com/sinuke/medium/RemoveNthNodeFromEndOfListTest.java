package com.sinuke.medium;

import com.sinuke.common.data.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.sinuke.common.data.ListNode.buildList;
import static com.sinuke.common.data.ListNode.toArray;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class RemoveNthNodeFromEndOfListTest {

    @ParameterizedTest
    @MethodSource("testData")
    void removeNthFromEnd(ListNode head, int n, ListNode expected) {
        var solution = new RemoveNthNodeFromEndOfList();
        assertArrayEquals(toArray(expected), toArray(solution.removeNthFromEnd(head, n)));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildList(1,2,3,4,5), 2, buildList(1,2,3,5)),
                Arguments.of(buildList(1), 1, buildList()),
                Arguments.of(buildList(1,2), 1, buildList(1))
        );
    }

}
