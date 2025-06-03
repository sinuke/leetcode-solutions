package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArrayPartitionTest {

    @ParameterizedTest
    @MethodSource("testData")
    void arrayPairSum(int[] nums, int expected) {
        var solution = new ArrayPartition();
        assertEquals(expected, solution.arrayPairSum(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,4,3,2}, 4),
                Arguments.of(new int[] {6,2,6,5,1,2}, 9)
        );
    }

}
