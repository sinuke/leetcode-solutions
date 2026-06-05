package com.sinuke.medium;

import com.sinuke.common.data.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.sinuke.common.data.ListNode.buildList;
import static com.sinuke.common.data.ListNode.toArray;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class RemoveDuplicatesFromSortedListIITest {

    @ParameterizedTest
    @MethodSource("testData")
    void deleteDuplicates(ListNode head, ListNode expected) {
        assertArrayEquals(toArray(expected), toArray(new RemoveDuplicatesFromSortedListII().deleteDuplicates(head)));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildList(1, 2, 3, 3, 4, 4, 5), buildList(1, 2, 5)),
                Arguments.of(buildList(1, 1, 1, 2, 3), buildList(2, 3))
        );
    }

}
