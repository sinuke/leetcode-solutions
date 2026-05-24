package com.sinuke.medium;

import com.sinuke.common.data.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.sinuke.common.data.ListNode.buildList;
import static com.sinuke.common.data.ListNode.toArray;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SortListTest {

    @ParameterizedTest
    @MethodSource("testData")
    void sortList(ListNode head, ListNode expected) {
        assertArrayEquals(toArray(expected), toArray(new SortList().sortList(head)));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildList(4, 2, 1, 3), buildList(1, 2, 3, 4)),
                Arguments.of(buildList(-1, 5, 3, 4, 0), buildList(-1, 0, 3, 4, 5)),
                Arguments.of(buildList(), buildList())
        );
    }

}
