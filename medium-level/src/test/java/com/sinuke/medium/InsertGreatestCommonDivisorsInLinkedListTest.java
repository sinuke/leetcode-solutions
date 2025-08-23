package com.sinuke.medium;

import com.sinuke.common.data.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.sinuke.common.data.ListNode.createList;
import static com.sinuke.common.data.ListNode.extractValues;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class InsertGreatestCommonDivisorsInLinkedListTest {

    @ParameterizedTest
    @MethodSource("testData")
    void insertGreatestCommonDivisors(ListNode head, ListNode expected) {
        var solution = new InsertGreatestCommonDivisorsInLinkedList();
        assertArrayEquals(extractValues(expected), extractValues(solution.insertGreatestCommonDivisors(head)));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(createList(18,6,10,3), createList(18,6,6,2,10,1,3)),
                Arguments.of(createList(7), createList(7))
        );
    }

}
