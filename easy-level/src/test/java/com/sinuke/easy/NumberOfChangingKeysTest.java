package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberOfChangingKeysTest {

    @ParameterizedTest
    @MethodSource("testData")
    void countKeyChanges(String s, int expected) {
        var solution = new NumberOfChangingKeys();
        assertEquals(expected, solution.countKeyChanges(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("aAbBcC", 2),
                Arguments.of("AaAaAaaA", 0)
        );
    }

}
