package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SplitTheArrayTest {

    @ParameterizedTest
    @MethodSource("testData")
    void isPossibleToSplit(int[] nums, boolean expected) {
        var solution = new SplitTheArray();
        assertEquals(expected, solution.isPossibleToSplit(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,1,2,2,3,4}, true),
                Arguments.of(new int[] {1,1,1,1}, false)
        );
    }

}
