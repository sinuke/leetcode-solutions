package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountLargestGroupTest {

    @ParameterizedTest
    @MethodSource("testData")
    void countLargestGroup(int n, int expected) {
        var solution = new CountLargestGroup();
        assertEquals(expected, solution.countLargestGroup(n));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(13, 4),
                Arguments.of(2, 2)
        );
    }

}
