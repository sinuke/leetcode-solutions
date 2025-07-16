package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxConsecutiveOnesTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findMaxConsecutiveOnes(int[] nums, int expected) {
        var solution = new MaxConsecutiveOnes();
        assertEquals(expected, solution.findMaxConsecutiveOnes(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,1,0,1,1,1}, 3),
                Arguments.of(new int[] {1,0,1,1,0,1}, 2)
        );
    }

}
