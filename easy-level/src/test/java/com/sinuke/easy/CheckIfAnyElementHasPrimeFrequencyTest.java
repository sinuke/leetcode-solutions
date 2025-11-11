package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckIfAnyElementHasPrimeFrequencyTest {

    @ParameterizedTest
    @MethodSource("testData")
    void checkPrimeFrequency(int[] nums, boolean expected) {
        var solution = new CheckIfAnyElementHasPrimeFrequency();
        assertEquals(expected, solution.checkPrimeFrequency(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,2,3,4,5,4}, true),
                Arguments.of(new int[] {1,2,3,4,5}, false),
                Arguments.of(new int[] {2,2,2,4,4}, true)
        );
    }

}
