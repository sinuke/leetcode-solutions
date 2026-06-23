package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberOfStudentsUnableToEatLunchTest {

    @ParameterizedTest
    @MethodSource("testData")
    void countStudents(int[] students, int[] sandwiches, int expected) {
        assertEquals(expected, new NumberOfStudentsUnableToEatLunch().countStudents(students, sandwiches));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{1, 1, 0, 0}, new int[]{0, 1, 0, 1}, 0),
                Arguments.of(new int[]{1, 1, 1, 0, 0, 1}, new int[]{1, 0, 0, 0, 1, 1}, 3)
        );
    }

}
