package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckIfTheNumberIsFascinatingTest {

    @ParameterizedTest
    @MethodSource("testData")
    void isFascinating(int n, boolean expected) {
        var solution = new CheckIfTheNumberIsFascinating();
        assertEquals(expected, solution.isFascinating(n));
        assertEquals(expected, solution.isFascinating2(n));
        assertEquals(expected, solution.isFascinating3(n));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(192, true),
                Arguments.of(100, false)
        );
    }

}
