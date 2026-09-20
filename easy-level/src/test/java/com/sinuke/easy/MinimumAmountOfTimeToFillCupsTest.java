package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumAmountOfTimeToFillCupsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void fillCups(int[] amount, int expected) {
        var solution = new MinimumAmountOfTimeToFillCups();
        assertEquals(expected, solution.fillCups(amount));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {1, 4, 2}, 4),
                Arguments.of(new int[] {5, 4, 4}, 7),
                Arguments.of(new int[] {5, 0, 0}, 5)
        );
    }

}
