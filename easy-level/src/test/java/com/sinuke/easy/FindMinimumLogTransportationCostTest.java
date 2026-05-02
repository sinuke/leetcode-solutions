package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindMinimumLogTransportationCostTest {

    @ParameterizedTest
    @MethodSource("testData")
    void minCuttingCost(int n, int m, int k, long expected) {
        assertEquals(expected, new FindMinimumLogTransportationCost().minCuttingCost(n, m, k));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(6, 5, 5, 5L),
                Arguments.of(4, 4, 6, 0L)
        );
    }

}
