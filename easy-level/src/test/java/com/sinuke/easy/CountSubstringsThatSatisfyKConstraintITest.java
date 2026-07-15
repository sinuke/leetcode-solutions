package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountSubstringsThatSatisfyKConstraintITest {

    @ParameterizedTest
    @MethodSource("testData")
    void countKConstraintSubstrings(String s, int k, int expected) {
        assertEquals(expected, new CountSubstringsThatSatisfyKConstraintI().countKConstraintSubstrings(s, k));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("10101", 1, 12),
                Arguments.of("1010101", 2, 25),
                Arguments.of("11111", 1, 15)
        );
    }

}
