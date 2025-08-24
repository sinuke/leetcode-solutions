package com.sinuke.medium;

import com.sinuke.common.data.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.sinuke.common.data.ListNode.buildList;
import static com.sinuke.common.data.ListNode.toArray;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class InsertGreatestCommonDivisorsInLinkedListTest {

    @ParameterizedTest
    @MethodSource("testData")
    void insertGreatestCommonDivisors(ListNode head, ListNode expected) {
        var solution = new InsertGreatestCommonDivisorsInLinkedList();
        assertArrayEquals(toArray(expected), toArray(solution.insertGreatestCommonDivisors(head)));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildList(18,6,10,3), buildList(18,6,6,2,10,1,3)),
                Arguments.of(buildList(7), buildList(7))
        );
    }

}
