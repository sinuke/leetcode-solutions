package com.sinuke;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumAveragePassRatioTest {

    @ParameterizedTest
    @MethodSource("testData")
    void maxAverageRatio(int[][] classes, int extraStudents, double expected) {
        var maximumAveragePassRatio = new MaximumAveragePassRatio();
        assertEquals(expected, maximumAveragePassRatio.maxAverageRatio(classes, extraStudents), 0.00001);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[][] {{1, 2}, {3, 5}, {2, 2}}, 2, 0.78333),
                Arguments.of(new int[][] {{2, 4}, {3, 9}, {4, 5}, {2, 10}}, 4, 0.53485)
        );
    }

}
