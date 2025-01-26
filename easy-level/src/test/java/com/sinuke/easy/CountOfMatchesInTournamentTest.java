package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountOfMatchesInTournamentTest {

    @ParameterizedTest
    @MethodSource("testData")
    void numberOfMatches(int n, int expected) {
        var counter = new CountOfMatchesInTournament();
        assertEquals(expected, counter.numberOfMatches(n));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(7, 6),
                Arguments.of(14, 13)
        );
    }

}
