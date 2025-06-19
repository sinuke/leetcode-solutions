package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AlternatingDigitSumTest {

    @ParameterizedTest
    @MethodSource("testData")
    void alternateDigitSum(int num, int expected) {
        var solution = new  AlternatingDigitSum();
        assertEquals(expected, solution.alternateDigitSum(num));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(521, 4),
                Arguments.of(111, 1),
                Arguments.of(886996, 0)
        );
    }

}
