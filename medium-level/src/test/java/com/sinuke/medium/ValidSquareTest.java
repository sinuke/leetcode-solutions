package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidSquareTest {

    @ParameterizedTest
    @MethodSource("testData")
    void validSquare(int[] p1, int[] p2, int[] p3, int[] p4, boolean expected) {
        var solution = new ValidSquare();
        assertEquals(expected, solution.validSquare(p1, p2, p3, p4));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {0,0}, new int[] {1,1}, new int[] {1,0}, new int[] {0,1}, true),
                Arguments.of(new int[] {0,0}, new int[] {1,1}, new int[] {1,0}, new int[] {0,12}, false),
                Arguments.of(new int[] {1,0}, new int[] {-1,0}, new int[] {0,1}, new int[] {0,-1}, true)
        );
    }

}
