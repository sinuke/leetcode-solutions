package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindClosestNumberToZeroTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findClosestNumber(int[] nums, int expected) {
        var solution = new FindClosestNumberToZero();
        assertEquals(expected, solution.findClosestNumber(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {-4,-2,1,4,8}, 1),
                Arguments.of(new int[] {2,-1,1}, 1)
        );
    }

}
