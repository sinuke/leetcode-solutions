package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumRecolorsToGetKConsecutiveBlackBlocksTest {

    @ParameterizedTest
    @MethodSource("testData")
    void minimumRecolors(String blocks, int k, int expected) {
        var solution = new MinimumRecolorsToGetKConsecutiveBlackBlocks();
        assertEquals(expected, solution.minimumRecolors(blocks, k));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("WBBWWBBWBW", 7, 3),
                Arguments.of("WBWBBBW", 2, 0),
                Arguments.of("BWWWBB", 6, 3)
        );
    }

}
