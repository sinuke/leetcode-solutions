package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MiddleOfTheLinkedListTest {

    @ParameterizedTest
    @MethodSource("testData")
    void middleNode(MiddleOfTheLinkedList.ListNode head, MiddleOfTheLinkedList.ListNode expected) {
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

    private static MiddleOfTheLinkedList.ListNode createList(int... values) {
        if (values.length == 0) return null;

        var head = new MiddleOfTheLinkedList.ListNode(values[0]);
        var previous = head;
        for (int i = 1; i < values.length; i++) {
            var element = new MiddleOfTheLinkedList.ListNode(values[i]);
            previous.next = element;
            previous = element;
        }

        return head;
    }

    private static int[] extractValues(MiddleOfTheLinkedList.ListNode node) {

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
