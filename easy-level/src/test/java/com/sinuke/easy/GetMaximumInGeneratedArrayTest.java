package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GetMaximumInGeneratedArrayTest {

    @ParameterizedTest
    @MethodSource("testData")
    void getMaximumGenerated(int n, int expected) {
        var solution = new GetMaximumInGeneratedArray();
        assertEquals(expected, solution.getMaximumGenerated(n));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(7, 3),
                Arguments.of(2, 1),
                Arguments.of(3, 2)
        );
    }

}
