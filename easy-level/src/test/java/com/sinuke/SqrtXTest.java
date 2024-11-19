package com.sinuke;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SqrtXTest {

    @ParameterizedTest
    @MethodSource("testData")
    void mySqrt(int num, int expected) {
        var sqrtX = new SqrtX();

        assertEquals(expected, sqrtX.mySqrt(num));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(4, 2),
                Arguments.of(81, 9),
                Arguments.of(8, 2),
                Arguments.of(1, 1),
                Arguments.of(0, 0),
                Arguments.of(2, 1),
                Arguments.of(3, 1),
                Arguments.of(2147395599, 46339),
                Arguments.of(2147483647, 46340)
        );
    }

}
