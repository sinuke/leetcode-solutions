package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SumOfValuesAtIndicesWithKSetBitsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void sumIndicesWithKSetBits(List<Integer> nums, int k, int expected) {
        var sumIndices = new SumOfValuesAtIndicesWithKSetBits();
        assertEquals(expected, sumIndices.sumIndicesWithKSetBits(nums, k));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(List.of(5,10,1,5,2), 1, 13),
                Arguments.of(List.of(4,3,2,1), 2, 1)
        );
    }

}
