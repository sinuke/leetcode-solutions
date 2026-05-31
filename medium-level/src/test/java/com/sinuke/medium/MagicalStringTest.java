package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MagicalStringTest {

    @ParameterizedTest
    @MethodSource("testData")
    void magicalString(int n, int expected) {
        assertEquals(expected, new MagicalString().magicalString(n));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(6, 3),
                Arguments.of(1, 1),
                Arguments.of(8, 4),
                Arguments.of(7, 4),
                Arguments.of(5, 3),
                Arguments.of(100000, 49972)
        );
    }

}
