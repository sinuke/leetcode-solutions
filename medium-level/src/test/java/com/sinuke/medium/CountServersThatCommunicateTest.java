package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountServersThatCommunicateTest {

    @ParameterizedTest
    @MethodSource("testData")
    void countServers(int[][] grid, int expected) {
        var solution = new CountServersThatCommunicate();
        assertEquals(expected, solution.countServers(grid));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[][] {{1, 0}, {0, 1}}, 0),
                Arguments.of(new int[][] {{1, 0}, {1, 1}}, 3),
                Arguments.of(new int[][] {{1, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}}, 4)
        );
    }

}
