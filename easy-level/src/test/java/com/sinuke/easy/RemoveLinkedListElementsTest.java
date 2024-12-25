package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class RemoveLinkedListElementsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void removeElements(RemoveLinkedListElements.ListNode head, int val, int[] expected) {
        var removeLinkedListElements = new RemoveLinkedListElements();

        var result = removeLinkedListElements.removeElements(head, val);
        int[] resultArray = extractValues(result);

        assertArrayEquals(expected, resultArray);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(createList(1, 2, 6, 3, 4, 5, 6), 6, new int[] {1, 2, 3, 4, 5}),
                Arguments.of(createList(), 1, null),
                Arguments.of(createList(7, 7, 7, 7), 7, null)
        );
    }

    private static RemoveLinkedListElements.ListNode createList(int... values) {
        if (values.length == 0) return null;

        var head = new RemoveLinkedListElements.ListNode(values[0]);
        var previous = head;
        for (int i = 1; i < values.length; i++) {
            var element = new RemoveLinkedListElements.ListNode(values[i]);
            previous.next = element;
            previous = element;
        }

        return head;
    }

    private static int[] extractValues(RemoveLinkedListElements.ListNode node) {
        if (node == null) return null;

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
