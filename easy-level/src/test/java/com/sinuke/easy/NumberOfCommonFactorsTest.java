package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberOfCommonFactorsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void commonFactors(int a, int b, int expected) {
        var solution = new NumberOfCommonFactors();
        assertEquals(expected, solution.commonFactors(a, b));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(12, 6, 4),
                Arguments.of(25, 30, 2)
        );
    }

}
