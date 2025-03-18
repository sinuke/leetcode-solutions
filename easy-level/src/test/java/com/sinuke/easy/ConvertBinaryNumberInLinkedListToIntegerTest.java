package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConvertBinaryNumberInLinkedListToIntegerTest {

    @ParameterizedTest
    @MethodSource("testData")
    void getDecimalValue(ConvertBinaryNumberInLinkedListToInteger.ListNode head, int expected) {
        var solution = new ConvertBinaryNumberInLinkedListToInteger();
        assertEquals(expected, solution.getDecimalValue(head));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(createList(1,0,1), 5),
                Arguments.of(createList(0), 0)
        );
    }

    private static ConvertBinaryNumberInLinkedListToInteger.ListNode createList(int... values) {
        if (values.length == 0) return new ConvertBinaryNumberInLinkedListToInteger.ListNode();

        var head = new ConvertBinaryNumberInLinkedListToInteger.ListNode(values[0]);
        var previous = head;
        for (int i = 1; i < values.length; i++) {
            var element = new ConvertBinaryNumberInLinkedListToInteger.ListNode(values[i]);
            previous.next = element;
            previous = element;
        }

        return head;
    }

}
