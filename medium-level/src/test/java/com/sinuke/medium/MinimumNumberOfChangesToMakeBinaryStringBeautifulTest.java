package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumNumberOfChangesToMakeBinaryStringBeautifulTest {

    @ParameterizedTest
    @MethodSource("testData")
    void minChanges(String s, int expected) {
        var solution = new MinimumNumberOfChangesToMakeBinaryStringBeautiful();
        assertEquals(expected, solution.minChanges(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("1001", 2),
                Arguments.of("10", 1),
                Arguments.of("0000", 0)
        );
    }

}
