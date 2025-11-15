package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculateDigitSumOfStringTest {

    @ParameterizedTest
    @MethodSource("testData")
    void digitSum(String s, int k, String expected) {
        var solution = new CalculateDigitSumOfString();
        assertEquals(expected, solution.digitSum(s, k));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("11111222223", 3, "135"),
                Arguments.of("00000000", 3, "000")
        );
    }

}
