package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class InsertGreatestCommonDivisorsInLinkedListTest {

    @ParameterizedTest
    @MethodSource("testData")
    void insertGreatestCommonDivisors(InsertGreatestCommonDivisorsInLinkedList.ListNode head, InsertGreatestCommonDivisorsInLinkedList.ListNode expected) {
        var solution = new InsertGreatestCommonDivisorsInLinkedList();
        assertArrayEquals(extractValues(expected), extractValues(solution.insertGreatestCommonDivisors(head)));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(createList(18,6,10,3), createList(18,6,6,2,10,1,3)),
                Arguments.of(createList(7), createList(7))
        );
    }

    private static InsertGreatestCommonDivisorsInLinkedList.ListNode createList(int... values) {
        if (values.length == 0) return null;

        var head = new InsertGreatestCommonDivisorsInLinkedList.ListNode(values[0]);
        var previous = head;
        for (int i = 1; i < values.length; i++) {
            var element = new InsertGreatestCommonDivisorsInLinkedList.ListNode(values[i]);
            previous.next = element;
            previous = element;
        }

        return head;
    }

    private static int[] extractValues(InsertGreatestCommonDivisorsInLinkedList.ListNode node) {

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
