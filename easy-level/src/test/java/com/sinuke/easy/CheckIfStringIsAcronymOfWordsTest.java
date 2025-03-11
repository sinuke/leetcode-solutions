package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckIfStringIsAcronymOfWordsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void isAcronym(List<String> words, String s, boolean expected) {
        var solution = new CheckIfStringIsAcronymOfWords();
        assertEquals(expected, solution.isAcronym(words, s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(List.of("alice","bob","charlie"), "abc", true),
                Arguments.of(List.of("an","apple"), "a", false),
                Arguments.of(List.of("never","gonna","give","up","on","you"), "ngguoy", true)
        );
    }

}
