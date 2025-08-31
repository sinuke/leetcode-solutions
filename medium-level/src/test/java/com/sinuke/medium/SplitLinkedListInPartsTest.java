package com.sinuke.medium;

import com.sinuke.common.data.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.sinuke.common.data.ListNode.buildList;
import static com.sinuke.common.data.ListNode.toArray;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SplitLinkedListInPartsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void splitListToParts(ListNode head, int k, ListNode[] expected) {
        var solution = new SplitLinkedListInParts();
        var actual = solution.splitListToParts(head, k);

        assertEquals(expected.length, actual.length);
        for (int i = 0; i < k; i++) {
            assertArrayEquals(toArray(expected[i]), toArray(actual[i]));
        }
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildList(1,2,3), 5, new ListNode[] {buildList(1), buildList(2), buildList(3), buildList(), buildList()}),
                Arguments.of(buildList(1,2,3,4,5,6,7,8,9,10), 3, new ListNode[] {buildList(1,2,3,4), buildList(5,6,7), buildList(8,9,10)})
        );
    }

}
