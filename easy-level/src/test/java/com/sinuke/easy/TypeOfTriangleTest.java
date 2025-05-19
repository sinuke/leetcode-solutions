package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TypeOfTriangleTest {

    @ParameterizedTest
    @MethodSource("testData")
    void triangleType(int[] nums, String expected) {
        var solution = new TypeOfTriangle();
        assertEquals(expected, solution.triangleType(nums));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {3,3,3}, "equilateral"),
                Arguments.of(new int[] {3,4,5}, "scalene")
        );
    }

}
