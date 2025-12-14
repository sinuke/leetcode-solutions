package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TheEmployeeThatWorkedOnTheLongestTaskTest {

    @ParameterizedTest
    @MethodSource("testData")
    void hardestWorker(int n, int[][] logs, int expected) {
        var solution = new TheEmployeeThatWorkedOnTheLongestTask();
        assertEquals(expected, solution.hardestWorker(n, logs));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(10, new int[][] {{0,3},{2,5},{0,9},{1,15}}, 1),
                Arguments.of(2, new int[][] {{0,10},{1,20}}, 0),
                Arguments.of(20, new int[][] {{1,1},{3,7},{2,12},{7,17}}, 3)
        );
    }

}
