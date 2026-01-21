package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SubarraysDistinctElementSumOfSquaresITest {

    @ParameterizedTest
    @MethodSource("testData")
    void sumCounts(List<Integer> nums, int expected) {
        var solution = new SubarraysDistinctElementSumOfSquaresI();
        assertEquals(expected, solution.sumCounts(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(List.of(1,2,1), 15),
                Arguments.of(List.of(1,1), 3)
        );
    }

}
