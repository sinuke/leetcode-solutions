package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class FindingTheUsersActiveMinutesTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findingUsersActiveMinutes(int[][] logs, int k, int[] expected) {
        var solution = new FindingTheUsersActiveMinutes();
        assertArrayEquals(expected, solution.findingUsersActiveMinutes(logs, k));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[][] {{0,5},{1,2},{0,2},{0,5},{1,3}}, 5, new int[] {0,2,0,0,0}),
                Arguments.of(new int[][] {{1,1},{2,2},{2,3}}, 4, new int[] {1,1,0,0})
        );
    }

}
