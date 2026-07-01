package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TotalWavinessOfNumbersInRangeITest {

    @ParameterizedTest
    @MethodSource("testData")
    void totalWaviness(int num1, int num2, int expected) {
        var solution = new TotalWavinessOfNumbersInRangeI();
        assertEquals(expected, solution.totalWaviness(num1, num2));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(120, 130, 3),
                Arguments.of(198, 202, 3),
                Arguments.of(4848, 4848, 2)
        );
    }

}
