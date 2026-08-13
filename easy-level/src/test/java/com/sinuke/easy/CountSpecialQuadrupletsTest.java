package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountSpecialQuadrupletsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void countQuadruplets(int[] nums, int expected) {
        var solution = new CountSpecialQuadruplets();
        assertEquals(expected, solution.countQuadruplets(nums));
    }

    static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 6}, 1),
                Arguments.of(new int[]{3, 3, 6, 4, 5}, 0),
                Arguments.of(new int[]{1, 1, 1, 3, 5}, 4)
        );
    }

}
