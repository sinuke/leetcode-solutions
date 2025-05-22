package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberOfStudentsDoingHomeworkAtGivenTimeTest {

    @ParameterizedTest
    @MethodSource("testData")
    void busyStudent(int[] startTime, int[] endTime, int queryTime, int expected) {
        var solution = new NumberOfStudentsDoingHomeworkAtGivenTime();
        assertEquals(expected, solution.busyStudent(startTime, endTime, queryTime));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1,2,3}, new int[] {3,2,7}, 4, 1),
                Arguments.of(new int[] {4}, new int[] {4}, 4, 1)
        );
    }

}
