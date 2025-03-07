package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HarshadNumberTest {

    @ParameterizedTest
    @MethodSource("testData")
    void sumOfTheDigitsOfHarshadNumber(int x, int expected) {
        var solution = new HarshadNumber();
        assertEquals(expected, solution.sumOfTheDigitsOfHarshadNumber(x));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(18, 9),
                Arguments.of(23, -1)
        );
    }

}
