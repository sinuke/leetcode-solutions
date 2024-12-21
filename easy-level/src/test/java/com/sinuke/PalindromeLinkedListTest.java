package com.sinuke;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PalindromeLinkedListTest {

    @ParameterizedTest
    @MethodSource("testData")
    void isPalindrome(PalindromeLinkedList.ListNode head, boolean expected) {
        var palindrome = new PalindromeLinkedList();
        assertEquals(expected, palindrome.isPalindrome(head));
        assertEquals(expected, palindrome.isPalindromeSlow(head));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(createList(1, 2, 2, 1), true),
                Arguments.of(createList(1, 2), false)
        );
    }

    private static PalindromeLinkedList.ListNode createList(int... values) {
        if (values.length == 0) return null;

        var head = new PalindromeLinkedList.ListNode(values[0]);
        var previous = head;
        for (int i = 1; i < values.length; i++) {
            var element = new PalindromeLinkedList.ListNode(values[i]);
            previous.next = element;
            previous = element;
        }

        return head;
    }

}