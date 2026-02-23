package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryGapTest {

    @ParameterizedTest
    @MethodSource("testData")
    void binaryGap(int n, int expected) {
        var solution = new BinaryGap();
        assertEquals(expected, solution.binaryGap(n));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(22, 2),
                Arguments.of(8, 0),
                Arguments.of(5, 2)
        );
    }

}
