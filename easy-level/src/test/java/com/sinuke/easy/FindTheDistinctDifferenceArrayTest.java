package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class FindTheDistinctDifferenceArrayTest {

    @ParameterizedTest
    @MethodSource("testData")
    void distinctDifferenceArray(int[] nums, int[] expected) {
        var solution = new FindTheDistinctDifferenceArray();
        assertArrayEquals(expected, solution.distinctDifferenceArray(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,2,3,4,5}, new int[] {-3,-1,1,3,5}),
                Arguments.of(new int[] {3,2,3,4,2}, new int[] {-2,-1,0,2,3})
        );
    }

}
