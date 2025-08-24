package com.sinuke.medium;

import com.sinuke.common.data.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.sinuke.common.data.ListNode.buildList;
import static com.sinuke.common.data.ListNode.toArray;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class AddTwoNumbersTest {

    @ParameterizedTest
    @MethodSource("testData")
    void addTwoNumbers(ListNode l1, ListNode l2, ListNode expected) {
        var addTwoNumbers = new AddTwoNumbers();

        var result = addTwoNumbers.addTwoNumbers(l1, l2);

        var expectedArray = toArray(expected);
        var actualArray = toArray(result);

        assertArrayEquals(expectedArray, actualArray);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(buildList(2, 4, 3), buildList(5, 6, 4), buildList(7, 0, 8)),
                Arguments.of(buildList(0), buildList(0), buildList(0)),
                Arguments.of(buildList(9, 9, 9, 9, 9, 9, 9), buildList(9, 9, 9, 9), buildList(8, 9, 9, 9, 0, 0, 0, 1)),
                Arguments.of(buildList(1, 8), buildList(0), buildList(1, 8))
        );
    }

}