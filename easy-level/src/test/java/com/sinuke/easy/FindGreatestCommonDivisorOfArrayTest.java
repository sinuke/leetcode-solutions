package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindGreatestCommonDivisorOfArrayTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findGCD(int[] nums, int expected) {
        var solution = new FindGreatestCommonDivisorOfArray();
        assertEquals(expected, solution.findGCD(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {2,5,6,9,10}, 2),
                Arguments.of(new int[] {7,5,6,8,3}, 1),
                Arguments.of(new int[] {3,3}, 3)
        );
    }

}
