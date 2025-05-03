package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LargestPositiveIntegerThatExistsWithItsNegativeTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findMaxK(int[] nums, int expected) {
        var solution = new LargestPositiveIntegerThatExistsWithItsNegative();
        assertEquals(expected, solution.findMaxK(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {-1,2,-3,3}, 3),
                Arguments.of(new int[] {-1,10,6,7,-7,1}, 7),
                Arguments.of(new int[] {-10,8,6,7,-2,-3}, -1)
        );
    }

}
