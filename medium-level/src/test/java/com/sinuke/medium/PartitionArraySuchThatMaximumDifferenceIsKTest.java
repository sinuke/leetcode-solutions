package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PartitionArraySuchThatMaximumDifferenceIsKTest {

    @ParameterizedTest
    @MethodSource("testData")
    void partitionArray(int[] nums, int k, int expected) {
        var solution =  new PartitionArraySuchThatMaximumDifferenceIsK();
        assertEquals(expected, solution.partitionArray(nums, k));
    }

    private  static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {3,6,1,2,5}, 2, 2),
                Arguments.of(new int[] {1,2,3}, 1, 2),
                Arguments.of(new int[] {2,2,4,5}, 0, 3)
        );
    }

}
