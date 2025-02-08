package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindFirstPalindromicStringInArrayTest {

    @ParameterizedTest
    @MethodSource("testData")
    void firstPalindrome(String[] words, String expected) {
        var solution = new FindFirstPalindromicStringInArray();
        assertEquals(expected, solution.firstPalindrome(words));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new String[] {"abc","car","ada","racecar","cool"}, "ada"),
                Arguments.of(new String[] {"notapalindrome","racecar"}, "racecar"),
                Arguments.of(new String[] {"def","ghi"}, "")
        );
    }

}
