package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumHoursOfTrainingToWinCompetitionTest {

    @ParameterizedTest
    @MethodSource("testData")
    void minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience, int expected) {
        var solution = new MinimumHoursOfTrainingToWinCompetition();
        assertEquals(expected, solution.minNumberOfHours(initialEnergy, initialExperience, energy, experience));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(5, 3, new int[] {1, 4, 3, 2}, new int[] {2, 6, 3, 1}, 8),
                Arguments.of(2, 4, new int[] {1}, new int[] {3}, 0)
        );
    }

}
