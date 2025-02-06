package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumNumberOfMovesToSeatEveryoneTest {

    @ParameterizedTest
    @MethodSource("testData")
    void minMovesToSeat(int[] seats, int[] students, int expected) {
        var solution = new MinimumNumberOfMovesToSeatEveryone();
        assertEquals(expected, solution.minMovesToSeat(seats, students));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {3,1,5}, new int[] {2,7,4}, 4),
                Arguments.of(new int[] {4,1,5,9}, new int[] {1,3,2,6}, 7),
                Arguments.of(new int[] {2,2,6,6}, new int[] {1,3,2,6}, 4)
        );
    }

}
