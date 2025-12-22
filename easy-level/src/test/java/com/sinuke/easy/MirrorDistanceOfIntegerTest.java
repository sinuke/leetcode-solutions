package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MirrorDistanceOfIntegerTest {

    @ParameterizedTest
    @MethodSource("testData")
    void mirrorDistance(int n, int expected) {
        var solution = new MirrorDistanceOfInteger();
        assertEquals(expected, solution.mirrorDistance(n));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(25, 27),
                Arguments.of(10, 9),
                Arguments.of(7, 0)
        );
    }

}
