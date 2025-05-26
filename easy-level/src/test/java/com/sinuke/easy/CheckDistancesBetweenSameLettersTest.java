package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckDistancesBetweenSameLettersTest {

    @ParameterizedTest
    @MethodSource("testData")
    void checkDistances(String s, int[] distance, boolean expected) {
        var solution = new CheckDistancesBetweenSameLetters();
        assertEquals(expected, solution.checkDistances(s, distance));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("abaccb", new int[] {1,3,0,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, true),
                Arguments.of("aa", new int[] {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, false)
        );
    }

}
