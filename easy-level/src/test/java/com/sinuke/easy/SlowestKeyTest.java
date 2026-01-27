package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SlowestKeyTest {

    @ParameterizedTest
    @MethodSource("testData")
    void slowestKey(int[] releaseTimes, String keysPressed, char expected) {
        var solution = new SlowestKey();
        assertEquals(expected, solution.slowestKey(releaseTimes, keysPressed));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {9,29,49,50}, "cbcd", 'c'),
                Arguments.of(new int[] {12,23,36,46,62}, "spuda", 'a')
        );
    }

}
