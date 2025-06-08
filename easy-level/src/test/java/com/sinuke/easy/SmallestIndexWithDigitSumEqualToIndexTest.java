package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SmallestIndexWithDigitSumEqualToIndexTest {

    @ParameterizedTest
    @MethodSource("testData")
    void smallestIndex(int[] nums, int expected) {
        var solution = new SmallestIndexWithDigitSumEqualToIndex();
        assertEquals(expected, solution.smallestIndex(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,3,2}, 2),
                Arguments.of(new int[] {1,10,11}, 1),
                Arguments.of(new int[] {1,2,3}, -1)
        );
    }

}
