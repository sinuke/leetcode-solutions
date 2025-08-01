package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConsecutiveCharactersTest {

    @ParameterizedTest
    @MethodSource("testData")
    void maxPower(String s, int expected) {
        var solution = new ConsecutiveCharacters();
        assertEquals(expected, solution.maxPower(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("leetcode", 2),
                Arguments.of("abbcccddddeeeeedcba", 5)
        );
    }

}
