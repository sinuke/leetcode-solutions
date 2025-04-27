package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SumOfAllOddLengthSubarraysTest {

    @ParameterizedTest
    @MethodSource("testData")
    void sumOddLengthSubarrays(int[] arr, int expected) {
        var solution = new SumOfAllOddLengthSubarrays();
        assertEquals(expected, solution.sumOddLengthSubarrays(arr));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,4,2,5,3}, 58),
                Arguments.of(new int[] {1,2}, 3),
                Arguments.of(new int[] {10,11,12}, 66)
        );
    }

}
