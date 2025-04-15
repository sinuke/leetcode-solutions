package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SmallestIndexWithEqualValueTest {

    @ParameterizedTest
    @MethodSource("testData")
    void smallestEqual(int[] nums, int expected) {
        var solution = new SmallestIndexWithEqualValue();
        assertEquals(expected, solution.smallestEqual(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {0,1,2}, 0),
                Arguments.of(new int[] {4,3,2,1}, 2),
                Arguments.of(new int[] {1,2,3,4,5,6,7,8,9,0}, -1)
        );
    }

}
