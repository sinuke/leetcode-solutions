package com.sinuke.medium;

import com.sinuke.common.data.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.sinuke.common.data.ListNode.buildList;
import static com.sinuke.common.data.ListNode.toArray;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ReorderListTest {

    @ParameterizedTest
    @MethodSource("testData")
    void reorderList(ListNode head, ListNode expected) {
        new ReorderList().reorderList(head);
        assertArrayEquals(toArray(expected), toArray(head));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildList(1, 2, 3, 4), buildList(1, 4, 2, 3)),
                Arguments.of(buildList(1, 2, 3, 4, 5), buildList(1, 5, 2, 4, 3))
        );
    }

}
