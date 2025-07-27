package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExistenceOfSubstringInStringAndItsReverseTest {

    @ParameterizedTest
    @MethodSource("testData")
    void isSubstringPresent(String s, boolean expected) {
        var solution = new ExistenceOfSubstringInStringAndItsReverse();
        assertEquals(expected, solution.isSubstringPresent(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("leetcode", true),
                Arguments.of("abcba", true),
                Arguments.of("abcd", false)
        );
    }

}
