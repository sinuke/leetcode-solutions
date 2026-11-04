package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RectangleAreaTest {

    @ParameterizedTest
    @MethodSource("testData")
    void computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2, int expected) {
        var solution = new RectangleArea();
        assertEquals(expected, solution.computeArea(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(-3, 0, 3, 4, 0, -1, 9, 2, 45),
                Arguments.of(-2, -2, 2, 2, -2, -2, 2, 2, 16)
        );
    }

}
