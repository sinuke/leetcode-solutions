package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckGoodIntegerTest {

    @ParameterizedTest
    @MethodSource("testData")
    void checkGoodInteger(int n, boolean expected) {
        assertEquals(expected, new CheckGoodInteger().checkGoodInteger(n));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(1000, false),
                Arguments.of(19, true)
        );
    }

}
