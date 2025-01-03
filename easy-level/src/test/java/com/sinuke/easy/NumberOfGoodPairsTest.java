package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberOfGoodPairsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void numIdenticalPairs(int[] nums, int expected) {
        var numberOfGoodPairs = new NumberOfGoodPairs();
        assertEquals(expected, numberOfGoodPairs.numIdenticalPairs(nums));
        assertEquals(expected, numberOfGoodPairs.numIdenticalPairs2(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,2,3,1,1,3}, 4),
                Arguments.of(new int[] {1,1,1,1}, 6),
                Arguments.of(new int[] {1,2,3}, 0)
        );
    }

}