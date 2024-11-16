package com.sinuke;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


class RemoveDuplicatesFromSortedListTest {

    @ParameterizedTest
    @MethodSource("testData")
    void deleteDuplicates(RemoveDuplicatesFromSortedList.ListNode input, RemoveDuplicatesFromSortedList.ListNode expected) {
        var removeDuplicates = new RemoveDuplicatesFromSortedList();

        var result = removeDuplicates.deleteDuplicates(input);
        var expectedArray = extractValues(expected);
        var resultArray = extractValues(result);

        assertArrayEquals(expectedArray, resultArray);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
            Arguments.of(createList(1, 1, 2), createList(1, 2)),
            Arguments.of(createList(1, 1, 2, 3, 3), createList(1, 2, 3))
        );
    }

    private static RemoveDuplicatesFromSortedList.ListNode createList(int... values) {
        if (values.length == 0) return new RemoveDuplicatesFromSortedList.ListNode();

        var head = new RemoveDuplicatesFromSortedList.ListNode(values[0]);
        var previous = head;
        for (int i = 1; i < values.length; i++) {
            var element = new RemoveDuplicatesFromSortedList.ListNode(values[i]);
            previous.next = element;
            previous = element;
        }

        return head;
    }

    private static int[] extractValues(RemoveDuplicatesFromSortedList.ListNode node) {

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
