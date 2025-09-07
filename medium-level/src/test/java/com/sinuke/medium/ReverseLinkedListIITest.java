package com.sinuke.medium;

import com.sinuke.common.data.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.sinuke.common.data.ListNode.buildList;
import static com.sinuke.common.data.ListNode.toArray;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ReverseLinkedListIITest {

    @ParameterizedTest
    @MethodSource("testData")
    void reverseBetween(ListNode head, int left, int right, ListNode expected) {
        var solution = new ReverseLinkedListII();
        assertArrayEquals(toArray(expected), toArray(solution.reverseBetween(head, left, right)));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildList(1,2,3,4,5), 2, 4, buildList(1,4,3,2,5)),
                Arguments.of(buildList(5), 1, 1, buildList(5))
        );
    }

}
