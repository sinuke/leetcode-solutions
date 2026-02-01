package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DivideArrayIntoSubarraysWithMinimumCostITest {

    @ParameterizedTest
    @MethodSource("testData")
    void minimumCost(int[] nums, int expected) {
        var solution = new DivideArrayIntoSubarraysWithMinimumCostI();
        assertEquals(expected, solution.minimumCost(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,2,3,12}, 6),
                Arguments.of(new int[] {5,4,3}, 12),
                Arguments.of(new int[] {10,3,1,1}, 12)
        );
    }

}
