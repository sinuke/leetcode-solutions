package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BasicCalculatorIITest {

    @ParameterizedTest
    @MethodSource("testData")
    void calculate(String s, int expected) {
        var solution = new BasicCalculatorII();
        assertEquals(expected, solution.calculate(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("3+2*2", 7),
                Arguments.of(" 3/2 ", 1),
                Arguments.of(" 3+5 / 2 ", 5)
        );
    }

}
