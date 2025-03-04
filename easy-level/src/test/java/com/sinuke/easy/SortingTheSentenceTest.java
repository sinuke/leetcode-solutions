package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SortingTheSentenceTest {

    @ParameterizedTest
    @MethodSource("testData")
    void sortSentence(String s, String expected) {
        var solution = new SortingTheSentence();
        assertEquals(expected, solution.sortSentence(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("is2 sentence4 This1 a3", "This is a sentence"),
                Arguments.of("Myself2 Me1 I4 and3", "Me Myself and I")
        );
    }

}
