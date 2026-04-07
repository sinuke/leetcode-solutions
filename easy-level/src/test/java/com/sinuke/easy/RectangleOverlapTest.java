package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RectangleOverlapTest {

    @ParameterizedTest
    @MethodSource("testData")
    void isRectangleOverlap(int[] rec1, int[] rec2, boolean expected) {
        assertEquals(expected, new RectangleOverlap().isRectangleOverlap(rec1, rec2));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{0, 0, 2, 2}, new int[]{1, 1, 3, 3}, true),
                Arguments.of(new int[]{0, 0, 1, 1}, new int[]{1, 0, 2, 1}, false),
                Arguments.of(new int[]{0, 0, 1, 1}, new int[]{2, 2, 3, 3}, false)
        );
    }

}
