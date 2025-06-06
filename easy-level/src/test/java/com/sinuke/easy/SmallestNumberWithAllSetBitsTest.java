package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SmallestNumberWithAllSetBitsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void smallestNumber(int n, int expected) {
        var solution = new SmallestNumberWithAllSetBits();
        assertEquals(expected, solution.smallestNumber(n));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(5, 7),
                Arguments.of(10, 15),
                Arguments.of(3, 3)
        );
    }

}
