package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StrictlyPalindromicNumberTest {

    @ParameterizedTest
    @MethodSource("testData")
    void isStrictlyPalindromic(int n, boolean expected) {
        var solution = new StrictlyPalindromicNumber();
        assertEquals(expected, solution.isStrictlyPalindromic(n));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(9, false),
                Arguments.of(4, false)
        );
    }

}
