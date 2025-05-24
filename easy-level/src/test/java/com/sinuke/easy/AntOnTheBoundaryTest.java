package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AntOnTheBoundaryTest {

    @ParameterizedTest
    @MethodSource("testData")
    void returnToBoundaryCount(int[] nums, int expected) {
        var solution = new AntOnTheBoundary();
        assertEquals(expected, solution.returnToBoundaryCount(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {2,3,-5}, 1),
                Arguments.of(new int[] {3,2,-3,-4}, 0)
        );
    }

}
