package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberOfUnequalTripletsInArrayTest {

    @ParameterizedTest
    @MethodSource("testData")
    void unequalTriplets(int[] nums, int expected) {
        var solution = new NumberOfUnequalTripletsInArray();
        assertEquals(expected, solution.unequalTriplets(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {4,4,2,4,3}, 3),
                Arguments.of(new int[] {1,1,1,1,1}, 0)
        );
    }

}
