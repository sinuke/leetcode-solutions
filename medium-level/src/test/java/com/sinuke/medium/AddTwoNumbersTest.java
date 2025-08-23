package com.sinuke.medium;

import com.sinuke.common.data.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.sinuke.common.data.ListNode.createList;
import static com.sinuke.common.data.ListNode.extractValues;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class AddTwoNumbersTest {

    @ParameterizedTest
    @MethodSource("testData")
    void addTwoNumbers(ListNode l1, ListNode l2, ListNode expected) {
        var addTwoNumbers = new AddTwoNumbers();

        var result = addTwoNumbers.addTwoNumbers(l1, l2);

        var expectedArray = extractValues(expected);
        var actualArray = extractValues(result);

        assertArrayEquals(expectedArray, actualArray);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(createList(2, 4, 3), createList(5, 6, 4), createList(7, 0, 8)),
                Arguments.of(createList(0), createList(0), createList(0)),
                Arguments.of(createList(9, 9, 9, 9, 9, 9, 9), createList(9, 9, 9, 9), createList(8, 9, 9, 9, 0, 0, 0, 1)),
                Arguments.of(createList(1, 8), createList(0), createList(1, 8))
        );
    }

}