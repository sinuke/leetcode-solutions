package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MostVisitedSectorInCircularTrackTest {

    @ParameterizedTest
    @MethodSource("testData")
    void mostVisited(int n, int[] rounds, List<Integer> expected) {
        assertEquals(expected, new MostVisitedSectorInCircularTrack().mostVisited(n, rounds));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(4, new int[]{1, 3, 1, 2}, List.of(1, 2)),
                Arguments.of(2, new int[]{2, 1, 2, 1, 2, 1, 2, 1, 2}, List.of(2)),
                Arguments.of(7, new int[]{1, 3, 5, 7}, List.of(1, 2, 3, 4, 5, 6, 7))
        );
    }

}
