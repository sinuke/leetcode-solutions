package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountElementsWithMaximumFrequencyTest {

    @ParameterizedTest
    @MethodSource("testData")
    void maxFrequencyElements(int[] nums, int expected) {
        var solution = new CountElementsWithMaximumFrequency();
        assertEquals(expected, solution.maxFrequencyElements(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,2,2,3,1,4}, 4),
                Arguments.of(new int[] {1,2,3,4,5}, 5)
        );
    }

}
