package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ReverseLinkedListTest {

    @ParameterizedTest
    @MethodSource("testData")
    void reverseList(ReverseLinkedList.ListNode head, ReverseLinkedList.ListNode expected) {
        var reverseLinkedList = new ReverseLinkedList();
        
        var result = reverseLinkedList.reverseList(head);
        var expectedArray = extractValues(expected);
        var resultArray = extractValues(result);
        
        assertArrayEquals(expectedArray, resultArray);
    }

    @ParameterizedTest
    @MethodSource("testData")
    void reverseListRecursive(ReverseLinkedList.ListNode head, ReverseLinkedList.ListNode expected) {
        var reverseLinkedList = new ReverseLinkedList();

        var result = reverseLinkedList.reverseListRecursive(head);
        var expectedArray = extractValues(expected);
        var resultArray = extractValues(result);

        assertArrayEquals(expectedArray, resultArray);
    }
    
    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(createList(1, 2, 3, 4, 5), createList(5, 4, 3, 2, 1)),
                Arguments.of(createList(1, 2), createList(2, 1)),
                Arguments.of(createList(), createList())
        );
    }

    private static ReverseLinkedList.ListNode createList(int... values) {
        if (values.length == 0) return null;

        var head = new ReverseLinkedList.ListNode(values[0]);
        var previous = head;
        for (int i = 1; i < values.length; i++) {
            var element = new ReverseLinkedList.ListNode(values[i]);
            previous.next = element;
            previous = element;
        }

        return head;
    }

    private static int[] extractValues(ReverseLinkedList.ListNode node) {

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
