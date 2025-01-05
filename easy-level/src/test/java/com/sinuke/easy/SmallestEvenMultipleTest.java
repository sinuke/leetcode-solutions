package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SmallestEvenMultipleTest {

    @ParameterizedTest
    @MethodSource("testData")
    void smallestEvenMultiple(int n, int expected) {
        var smallestEvenMultiple = new SmallestEvenMultiple();
        assertEquals(expected, smallestEvenMultiple.smallestEvenMultiple(n));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(5, 10),
                Arguments.of(6, 6)
        );
    }

}
