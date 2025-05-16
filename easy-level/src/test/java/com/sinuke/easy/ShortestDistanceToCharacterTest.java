package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ShortestDistanceToCharacterTest {

    @ParameterizedTest
    @MethodSource("testData")
    void shortestToChar(String s, char c, int[] expected) {
        var solution = new ShortestDistanceToCharacter();
        assertArrayEquals(expected, solution.shortestToChar(s, c));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("loveleetcode", 'e', new int[] {3,2,1,0,1,0,0,1,2,2,1,0}),
                Arguments.of("aaab", 'b', new int[] {3,2,1,0})
        );
    }

}
