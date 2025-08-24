package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReverseIntegerTest {

    @ParameterizedTest
    @MethodSource("testData")
    void reverse(int x, int expected) {
        var solution = new ReverseInteger();
        assertEquals(expected, solution.reverse(x));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(123, 321),
                Arguments.of(-123, -321),
                Arguments.of(120, 21),
                Arguments.of(-2147483648, 0),
                Arguments.of(2147483647, 0),
                Arguments.of(-2147483412, -2143847412),
                Arguments.of(1534236469, 0)
        );
    }

}
