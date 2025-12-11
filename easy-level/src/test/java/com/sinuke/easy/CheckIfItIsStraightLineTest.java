package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckIfItIsStraightLineTest {

    @ParameterizedTest
    @MethodSource("testData")
    void checkStraightLine(int[][] coordinates, boolean expected) {
        var solution = new CheckIfItIsStraightLine();
        assertEquals(expected, solution.checkStraightLine(coordinates));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[][] {{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}}, true),
                Arguments.of(new int[][] {{1,1},{2,2},{3,4},{4,5},{5,6},{7,7}}, false)
        );
    }

}
