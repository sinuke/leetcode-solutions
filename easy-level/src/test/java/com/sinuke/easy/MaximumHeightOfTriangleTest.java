package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumHeightOfTriangleTest {

    @ParameterizedTest
    @MethodSource("testData")
    void maxHeightOfTriangle(int red, int blue, int expected) {
        assertEquals(expected, new MaximumHeightOfTriangle().maxHeightOfTriangle(red, blue));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(2, 4, 3),
                Arguments.of(2, 1, 2)
        );
    }

}
