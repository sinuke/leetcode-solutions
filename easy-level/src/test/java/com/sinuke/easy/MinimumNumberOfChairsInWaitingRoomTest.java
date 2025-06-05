package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumNumberOfChairsInWaitingRoomTest {

    @ParameterizedTest
    @MethodSource("testData")
    void minimumChairs(String s, int expected) {
        var solution = new MinimumNumberOfChairsInWaitingRoom();
        assertEquals(expected, solution.minimumChairs(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("EEEEEEE", 7),
                Arguments.of("ELELEEL", 2),
                Arguments.of("ELEELEELLL", 3)
        );
    }

}
