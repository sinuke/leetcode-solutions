package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ConstructTheMinimumBitwiseArrayITest {

    @ParameterizedTest
    @MethodSource("testData")
    void minBitwiseArray(List<Integer> nums, int[] expected) {
        var solution = new ConstructTheMinimumBitwiseArrayI();
        assertArrayEquals(expected, solution.minBitwiseArray(nums));
        assertArrayEquals(expected, solution.minBitwiseArray2(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(List.of(2,3,5,7), new int[] {-1,1,4,3}),
                Arguments.of(List.of(11,13,31), new int[] {9,12,15})
        );
    }

}
