package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountRotationsWithExactlyKEqualAdjacentPairsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void countRotations(String s, int k, int expected) {
        var countRotations = new CountRotationsWithExactlyKEqualAdjacentPairs();
        assertEquals(expected, countRotations.countRotations(s, k));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("aab", 1, 2),
                Arguments.of("abca", 0, 1)
        );
    }

}
