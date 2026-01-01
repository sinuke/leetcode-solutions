package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumNumberOfOperationsWithTheSameScoreITest {

    @ParameterizedTest
    @MethodSource("testData")
    void maxOperations(int[] nums, int expected) {
        var solution = new MaximumNumberOfOperationsWithTheSameScoreI();
        assertEquals(expected, solution.maxOperations(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {3,2,1,4,5}, 2),
                Arguments.of(new int[] {1,5,3,3,4,1,3,2,2,3}, 2),
                Arguments.of(new int[] {5,3}, 1)
        );
    }

}
