package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringMatchingInArrayTest {

    @ParameterizedTest
    @MethodSource("testData")
    void stringMatching(String[] words, List<String> expected) {
        var stringMatcher = new StringMatchingInArray();
        assertEquals(expected, stringMatcher.stringMatching(words));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new String[] {"mass","as","hero","superhero"}, List.of("as","hero")),
                Arguments.of(new String[] {"leetcode","et","code"}, List.of("et","code")),
                Arguments.of(new String[] {"blue","green","bu"}, List.of())
        );
    }

}
