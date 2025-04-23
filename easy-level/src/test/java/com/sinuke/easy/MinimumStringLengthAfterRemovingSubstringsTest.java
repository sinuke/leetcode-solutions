package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumStringLengthAfterRemovingSubstringsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void minLength(String s, int expected) {
        var solution = new MinimumStringLengthAfterRemovingSubstrings();
        assertEquals(expected, solution.minLength(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("ABFCACDB", 2),
                Arguments.of("ACBBD", 5)
        );
    }

}
