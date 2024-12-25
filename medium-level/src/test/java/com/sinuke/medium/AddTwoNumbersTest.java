package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class AddTwoNumbersTest {

    @ParameterizedTest
    @MethodSource("testData")
    void addTwoNumbers(AddTwoNumbers.ListNode l1, AddTwoNumbers.ListNode l2, AddTwoNumbers.ListNode expected) {
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

    private static AddTwoNumbers.ListNode createList(int... values) {
        if (values.length == 0) return null;

        var head = new AddTwoNumbers.ListNode(values[0]);
        var previous = head;
        for (int i = 1; i < values.length; i++) {
            var element = new AddTwoNumbers.ListNode(values[i]);
            previous.next = element;
            previous = element;
        }

        return head;
    }

    private static int[] extractValues(AddTwoNumbers.ListNode node) {

        int count = 0;
        var first = node;
        while (node != null) {
            count++;
            node = node.next;
        }

        var result = new int[count];
        node = first;
        var index = 0;
        while (node != null) {
            result[index] = node.val;
            node = node.next;
            index++;
        }

        return result;
    }

}