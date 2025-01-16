package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumSumOfFourDigitNumberAfterSplittingDigitsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void minimumSum(int num, int expected) {
        var minimumSum = new MinimumSumOfFourDigitNumberAfterSplittingDigits();
        assertEquals(expected, minimumSum.minimumSum(num));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(2932, 52),
                Arguments.of(4009, 13)
        );
    }

}
