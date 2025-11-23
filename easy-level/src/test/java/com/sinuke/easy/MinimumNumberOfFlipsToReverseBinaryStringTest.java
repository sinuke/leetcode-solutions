package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumNumberOfFlipsToReverseBinaryStringTest {

    @ParameterizedTest
    @MethodSource("testData")
    void minimumFlips(int n, int expected) {
        var solution = new MinimumNumberOfFlipsToReverseBinaryString();
        assertEquals(expected, solution.minimumFlips(n));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(7, 0),
                Arguments.of(10, 4)
        );
    }

}
