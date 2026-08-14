package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindValidPairOfAdjacentDigitsInStringTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findValidPair(String s, String expected) {
        var solution = new FindValidPairOfAdjacentDigitsInString();
        assertEquals(expected, solution.findValidPair(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("2523533", "23"),
                Arguments.of("221", "21"),
                Arguments.of("22", "")
        );
    }

}