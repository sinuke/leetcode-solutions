package com.sinuke.hard;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BasicCalculatorTest {

    @ParameterizedTest
    @MethodSource("testData")
    void calculate(String s, int expected) {
        var solution = new BasicCalculator();
        assertEquals(expected, solution.calculate(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("1 + 1", 2),
                Arguments.of(" 2-1 + 2 ", 3),
                Arguments.of("(1+(4+5+2)-3)+(6+8)", 23),
                Arguments.of("- (3 + (4 + 5))", -12)
        );
    }

}
