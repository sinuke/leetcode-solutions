package com.sinuke.easy;

import com.sinuke.common.data.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.sinuke.common.data.ListNode.createList;
import static com.sinuke.common.data.ListNode.extractValues;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MiddleOfTheLinkedListTest {

    @ParameterizedTest
    @MethodSource("testData")
    void middleNode(ListNode head, ListNode expected) {
        var solution = new MiddleOfTheLinkedList();
        var expectedArray = extractValues(expected);
        var actualArray = extractValues(solution.middleNode(head));

        assertArrayEquals(expectedArray, actualArray);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(createList(1,2,3,4,5), createList(3,4,5)),
                Arguments.of(createList(1,2,3,4,5,6), createList(4,5,6)),
                Arguments.of(createList(1), createList(1))
        );
    }

}
