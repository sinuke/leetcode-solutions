package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PassThePillowTest {

    @ParameterizedTest
    @MethodSource("testData")
    void passThePillow(int n, int time, int expected) {
        var solution = new PassThePillow();
        assertEquals(expected, solution.passThePillow(n, time));
        assertEquals(expected, solution.passThePillow2(n, time));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(4, 5, 2),
                Arguments.of(3, 2, 3)
        );
    }

}
