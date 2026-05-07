package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumDeletionsForAtMostKDistinctCharactersTest {

    @ParameterizedTest
    @MethodSource("testData")
    void minDeletion(String s, int k, int expected) {
        var solution = new MinimumDeletionsForAtMostKDistinctCharacters();
        assertEquals(expected, solution.minDeletion(s, k));
        assertEquals(expected, solution.minDeletion2(s, k));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("abc", 2, 1),
                Arguments.of("aabb", 2, 0),
                Arguments.of("yyyzz", 1, 2)
        );
    }

}
