package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckIfStringsCanBeMadeEqualWithOperationsITest {

    @ParameterizedTest
    @MethodSource("testData")
    void canBeEqual(String s1, String s2, boolean expected) {
        var solution = new CheckIfStringsCanBeMadeEqualWithOperationsI();

        assertEquals(expected, solution.canBeEqual(s1, s2));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("abcd", "cdab", true),
                Arguments.of("abcd", "dacb", false)
        );
    }

}
