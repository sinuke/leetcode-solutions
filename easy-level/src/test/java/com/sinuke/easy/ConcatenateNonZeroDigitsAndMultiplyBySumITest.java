package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConcatenateNonZeroDigitsAndMultiplyBySumITest {

    @ParameterizedTest
    @MethodSource("testData")
    void sumAndMultiply(int n, long expected) {
        var solution = new ConcatenateNonZeroDigitsAndMultiplyBySumI();
        assertEquals(expected, solution.sumAndMultiply(n));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(10203004, 12340),
                Arguments.of(1000, 1)
        );
    }

}
