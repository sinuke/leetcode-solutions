package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


class RemovePalindromicSubsequencesTest {

    @ParameterizedTest
    @MethodSource("testData")
    void removePalindromeSub(String s, int expected) {
        assertEquals(expected, new RemovePalindromicSubsequences().removePalindromeSub(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("ababa", 1),
                Arguments.of("abb", 2),
                Arguments.of("baabb", 2)
        );
    }

}
