package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HeightCheckerTest {

    @ParameterizedTest
    @MethodSource("testData")
    void heightChecker(int[] heights, int expected) {
        var solution = new HeightChecker();
        assertEquals(expected, solution.heightChecker(heights));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,1,4,2,1,3}, 3),
                Arguments.of(new int[] {5,1,2,3,4}, 5),
                Arguments.of(new int[] {1,2,3,4,5}, 0)
        );
    }

}
