package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumMatchingOfPlayersWithTrainersTest {

    @ParameterizedTest
    @MethodSource("testData")
    void matchPlayersAndTrainers(int[] players, int[] trainers, int expected) {
        var solution = new MaximumMatchingOfPlayersWithTrainers();
        assertEquals(expected, solution.matchPlayersAndTrainers(players, trainers));
    }

    private static Stream<Arguments> testData() {
         return Stream.of(
                 Arguments.of(new int[] {4,7,9}, new int[] {8,2,5,8}, 2),
                 Arguments.of(new int[] {1,1,1}, new int[] {10}, 1)
         );
    }

}
