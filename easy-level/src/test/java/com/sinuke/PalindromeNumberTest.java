package com.sinuke;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PalindromeNumberTest {

    @Test
    void isPalindrome() {
        var palindrome = new PalindromeNumber();

        assertTrue(palindrome.isPalindrome(121));
        assertFalse(palindrome.isPalindrome(-121));
        assertFalse(palindrome.isPalindrome(10));
    }

}
