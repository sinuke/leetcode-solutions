package com.sinuke.hard;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumInitialEnergyToFinishTasksTest {

    @ParameterizedTest
    @MethodSource("testData")
    void minimumEffort(int[][] tasks, int expected) {
        assertEquals(expected, new MinimumInitialEnergyToFinishTasks().minimumEffort(tasks));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[][] {{1, 2}, {2, 4}, {4, 8}}, 8),
                Arguments.of(new int[][] {{1, 3}, {2, 4}, {10, 11}, {10, 12}, {8, 9}}, 32),
                Arguments.of(new int[][] {{1, 7}, {2, 8}, {3, 9}, {4, 10}, {5, 11}, {6, 12}}, 27)
        );
    }

}
