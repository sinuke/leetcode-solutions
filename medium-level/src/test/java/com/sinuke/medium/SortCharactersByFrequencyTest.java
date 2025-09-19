package com.sinuke.medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SortCharactersByFrequencyTest {

    @ParameterizedTest
    @MethodSource("testData")
    void frequencySort(String s, String expected) {
        var solution = new SortCharactersByFrequency();
        assertEquals(expected, solution.frequencySort(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("tree", "eert"),
                Arguments.of("cccaaa", "aaaccc"),
                Arguments.of("Aabb", "bbAa")
        );
    }

}
