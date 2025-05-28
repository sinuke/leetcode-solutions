package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PathCrossingTest {

    @ParameterizedTest
    @MethodSource("testData")
    void isPathCrossing(String path, boolean expected) {
        var solution = new PathCrossing();
        assertEquals(expected, solution.isPathCrossing(path));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("NES", false),
                Arguments.of("NESWW", true)
        );
    }

}
