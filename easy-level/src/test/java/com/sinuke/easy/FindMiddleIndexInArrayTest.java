package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindMiddleIndexInArrayTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findMiddleIndex(int[] nums, int expected) {
        var solution = new FindMiddleIndexInArray();
        assertEquals(expected, solution.findMiddleIndex(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {2, 3, -1, 8, 4}, 3),
                Arguments.of(new int[] {1, -1, 4}, 2),
                Arguments.of(new int[] {2, 5}, -1)
        );
    }

}
