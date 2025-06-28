package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ConstructTheRectangleTest {

    @ParameterizedTest
    @MethodSource("testData")
    void constructRectangle(int area, int[] expected) {
        var solution = new ConstructTheRectangle();
        assertArrayEquals(expected,solution.constructRectangle(area));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(4, new int[] {2, 2}),
                Arguments.of(37, new int[] {37, 1}),
                Arguments.of(122122, new int[] {427, 286})
        );
    }

}
