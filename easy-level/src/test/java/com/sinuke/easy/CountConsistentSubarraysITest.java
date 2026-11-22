package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountConsistentSubarraysITest {

    @ParameterizedTest
    @MethodSource("testData")
    void countConsistent(int[] nums, int expected) {
        var solution = new CountConsistentSubarraysI();
        assertEquals(expected, solution.countConsistent(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {5, 3, 1, 2}, 6),
                Arguments.of(new int[] {1, 1, 1}, 6),
                Arguments.of(new int[] {0}, 1)
        );
    }

}
