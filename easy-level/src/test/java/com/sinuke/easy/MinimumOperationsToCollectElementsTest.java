package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumOperationsToCollectElementsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void minOperations(List<Integer> nums, int k, int expected) {
        var solution = new MinimumOperationsToCollectElements();
        assertEquals(expected, solution.minOperations(nums, k));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(List.of(3, 1, 5, 4, 2), 2, 4),
                Arguments.of(List.of(3, 1, 5, 4, 2), 5, 5),
                Arguments.of(List.of(3, 2, 5, 3, 1), 3, 4)
        );
    }

}