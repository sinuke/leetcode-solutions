package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LargestNumberAfterDigitSwapsByParityTest {

    @ParameterizedTest
    @MethodSource("testData")
    void largestInteger(int num, int expected) {
        var solution = new LargestNumberAfterDigitSwapsByParity();
        assertEquals(expected, solution.largestInteger(num));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(1234, 3412),
                Arguments.of(65875, 87655)
        );
    }

}
