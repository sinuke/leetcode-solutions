package com.sinuke.easy;

import com.sinuke.common.data.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.sinuke.common.data.ListNode.createList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PalindromeLinkedListTest {

    @ParameterizedTest
    @MethodSource("testData")
    void isPalindrome(ListNode head, boolean expected) {
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

}