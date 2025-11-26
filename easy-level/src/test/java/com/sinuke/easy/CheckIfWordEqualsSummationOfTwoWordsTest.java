package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckIfWordEqualsSummationOfTwoWordsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void isSumEqual(String firstWord, String secondWord, String targetWord, boolean expected) {
        var solution = new CheckIfWordEqualsSummationOfTwoWords();
        assertEquals(expected, solution.isSumEqual(firstWord, secondWord, targetWord));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("acb", "cba", "cdb", true),
                Arguments.of("aaa", "a", "aab", false),
                Arguments.of("aaa", "a", "aaaa", true)
        );
    }

}
