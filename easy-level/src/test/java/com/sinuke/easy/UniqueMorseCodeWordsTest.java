package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UniqueMorseCodeWordsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void uniqueMorseRepresentations(String[] words, int expected) {
        var solution = new UniqueMorseCodeWords();
        assertEquals(expected, solution.uniqueMorseRepresentations(words));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new String[] {"gin","zen","gig","msg"}, 2),
                Arguments.of(new String[] {"a"}, 1)
        );
    }

}