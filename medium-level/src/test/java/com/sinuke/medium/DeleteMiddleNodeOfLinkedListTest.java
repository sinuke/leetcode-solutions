package com.sinuke.medium;

import com.sinuke.common.data.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.sinuke.common.data.ListNode.buildList;
import static com.sinuke.common.data.ListNode.toArray;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DeleteMiddleNodeOfLinkedListTest {

    @ParameterizedTest
    @MethodSource("testData")
    void deleteMiddle(ListNode head, ListNode expected) {
        assertArrayEquals(toArray(expected), toArray(new DeleteMiddleNodeOfLinkedList().deleteMiddle(head)));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildList(1, 3, 4, 7, 1, 2, 6), buildList(1, 3, 4, 1, 2, 6)),
                Arguments.of(buildList(1, 2, 3, 4), buildList(1, 2, 4)),
                Arguments.of(buildList(2, 1), buildList(2))
        );
    }

}
