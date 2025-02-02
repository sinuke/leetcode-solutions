package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DifferenceBetweenElementSumAndDigitSumOfArrayTest {

    @ParameterizedTest
    @MethodSource("testData")
    void differenceOfSum(int[] nums, int expected) {
        var difference = new DifferenceBetweenElementSumAndDigitSumOfArray();
        assertEquals(expected, difference.differenceOfSum(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,15,6,3}, 9),
                Arguments.of(new int[] {1,2,3,4}, 0)
        );
    }

}
