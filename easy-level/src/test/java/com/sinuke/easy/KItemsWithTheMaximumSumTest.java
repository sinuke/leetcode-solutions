package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KItemsWithTheMaximumSumTest {

    @ParameterizedTest
    @MethodSource("testData")
    void kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k, int expected) {
        var solution = new KItemsWithTheMaximumSum();
        assertEquals(expected, solution.kItemsWithMaximumSum(numOnes, numZeros, numNegOnes, k));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(3, 2, 0, 2, 2),
                Arguments.of(3, 2, 0, 4, 3)
        );
    }

}
