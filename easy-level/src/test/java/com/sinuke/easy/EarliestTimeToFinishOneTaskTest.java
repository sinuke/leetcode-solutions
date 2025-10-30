package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EarliestTimeToFinishOneTaskTest {

    @ParameterizedTest
    @MethodSource("testData")
    void earliestTime(int[][] tasks, int expected) {
        var solution = new EarliestTimeToFinishOneTask();
        assertEquals(expected, solution.earliestTime(tasks));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[][] {{1,6},{2,3}}, 5),
                Arguments.of(new int[][] {{100,100},{100,100},{100,100}}, 200)
        );
    }

}
