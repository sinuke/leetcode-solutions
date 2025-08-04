package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PerfectNumberTest {

    @ParameterizedTest
    @MethodSource("testData")
    void checkPerfectNumber(int num, boolean expected) {
        var solution = new PerfectNumber();
        assertEquals(expected, solution.checkPerfectNumber(num));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(28, true),
                Arguments.of(7, false),
                Arguments.of(1, false)
        );
    }

}
