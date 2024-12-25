package com.sinuke;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidPerfectSquareTest {

    @ParameterizedTest
    @MethodSource("testData")
    void isPerfectSquare(int num, boolean expected) {
        var perfectSquare = new ValidPerfectSquare();
        assertEquals(expected, perfectSquare.isPerfectSquare(num));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(16, true),
                Arguments.of(1, true),
                Arguments.of(14, false)
        );
    }

}
