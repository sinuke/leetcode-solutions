package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NRepeatedElementInSize2NArrayTest {

    @ParameterizedTest
    @MethodSource("testData")
    void repeatedNTimes(int[] nums, int expected) {
        var solution = new NRepeatedElementInSize2NArray();
        assertEquals(expected, solution.repeatedNTimes(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,2,3,3}, 3),
                Arguments.of(new int[] {2,1,2,5,3,2}, 2),
                Arguments.of(new int[] {5,1,5,2,5,3,5,4}, 5)
        );
    }

}
