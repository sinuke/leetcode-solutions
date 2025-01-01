package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class BuildArrayFromPermutationTest {

    @ParameterizedTest
    @MethodSource("testData")
    void buildArray(int[] nums, int[] expected) {
        var permutation = new BuildArrayFromPermutation();
        assertArrayEquals(expected, permutation.buildArray(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {0,2,1,5,3,4}, new int[] {0,1,2,4,5,3}),
                Arguments.of(new int[] {5,0,1,2,3,4}, new int[] {4,5,0,1,2,3})
        );
    }

}
