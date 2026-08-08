package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SplitWithMinimumSumTest {

    @ParameterizedTest
    @MethodSource("testData")
    void splitNum(int num, int expected) {
        var splitWithMinimumSum = new SplitWithMinimumSum();
        assertEquals(expected, splitWithMinimumSum.splitNum(num));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(4325, 59),
                Arguments.of(687, 75)
        );
    }

}