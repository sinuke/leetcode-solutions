package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindTriangularSumOfArrayTest {

    @ParameterizedTest
    @MethodSource("testData")
    void triangularSum(int[] nums, int expected) {
        var solution = new FindTriangularSumOfArray();
        assertEquals(expected, solution.triangularSum(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,2,3,4,5}, 8),
                Arguments.of(new int[] {5}, 5)
        );
    }

}
