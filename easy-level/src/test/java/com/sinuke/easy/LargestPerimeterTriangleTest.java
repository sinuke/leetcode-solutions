package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LargestPerimeterTriangleTest {

    @ParameterizedTest
    @MethodSource("testData")
    void largestPerimeter(int[] nums, int expected) {
        var solution = new LargestPerimeterTriangle();
        assertEquals(expected, solution.largestPerimeter(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {2,1,2}, 5),
                Arguments.of(new int[] {1,2,1,10}, 0)
        );
    }

}
