package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckIfBitwiseORHasTrailingZerosTest {

    @ParameterizedTest
    @MethodSource("testData")
    void hasTrailingZeros(int[] nums, boolean expected) {
        var solution = new CheckIfBitwiseORHasTrailingZeros();
        assertEquals(expected, solution.hasTrailingZeros(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,2,3,4,5}, true),
                Arguments.of(new int[] {2,4,8,16}, true),
                Arguments.of(new int[] {1,3,5,7,9}, false)
        );
    }

}
