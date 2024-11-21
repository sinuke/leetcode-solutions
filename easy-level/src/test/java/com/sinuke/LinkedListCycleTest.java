package com.sinuke;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


class LinkedListCycleTest {

    @ParameterizedTest
    @MethodSource("testData")
    void hasCycle(LinkedListCycle.ListNode input, boolean expected) {
        var linkedListCycle = new LinkedListCycle();

        assertEquals(expected, linkedListCycle.hasCycle(input));
        assertEquals(expected, linkedListCycle.hasCycleTwoPointers(input));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(createList(1, 3, 2, 0, -4), true),
                Arguments.of(createList(0, 1, 2), true),
                Arguments.of(createList(-1, 1), false),
                Arguments.of(createList(-1), false)
        );
    }


    private static LinkedListCycle.ListNode createList(int pos, int... values) {
        if (values.length == 0) return null;

        var head = new LinkedListCycle.ListNode(values[0]);
        var previous = head;
        LinkedListCycle.ListNode element = null;

        LinkedListCycle.ListNode posElement = null;
        if (pos == 0) posElement = head;

        for (int i = 1; i < values.length; i++) {
            element = new LinkedListCycle.ListNode(values[i]);
            previous.next = element;
            previous = element;

            if (pos == i) posElement = element;
        }

        if (posElement != null) element.next = posElement;

        return head;
    }

}
