package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Maximum69NumberTest {

    @ParameterizedTest
    @MethodSource("testData")
    void maximum69Number(int num, int expected) {
        var solution = new Maximum69Number();
        assertEquals(expected, solution.maximum69Number(num));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(9669, 9969),
                Arguments.of(9996, 9999),
                Arguments.of(9999, 9999)
        );
    }

}