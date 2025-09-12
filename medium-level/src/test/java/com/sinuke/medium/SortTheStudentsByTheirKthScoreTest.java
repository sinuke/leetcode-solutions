package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SortTheStudentsByTheirKthScoreTest {

    @ParameterizedTest
    @MethodSource("testData")
    void sortTheStudents(int[][] score, int k, int[][] expected) {
        var solution = new SortTheStudentsByTheirKthScore();
        assertArrayEquals(expected, solution.sortTheStudents(score, k));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[][] {{10,6,9,1},{7,5,11,2},{4,8,3,15}}, 2, new int[][] {{7,5,11,2},{10,6,9,1},{4,8,3,15}}),
                Arguments.of(new int[][] {{3,4},{5,6}}, 0, new int[][] {{5,6},{3,4}})
        );
    }

}
