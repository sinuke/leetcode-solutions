package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class UncommonWordsFromTwoSentencesTest {

    @ParameterizedTest
    @MethodSource("testData")
    void uncommonFromSentences(String s1, String s2, String[] expected) {
        var solution = new UncommonWordsFromTwoSentences();
        assertArrayEquals(expected, solution.uncommonFromSentences(s1, s2));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("this apple is sweet", "this apple is sour", new String[] {"sweet","sour"}),
                Arguments.of("apple apple", "banana", new String[] {"banana"})
        );
    }

}
