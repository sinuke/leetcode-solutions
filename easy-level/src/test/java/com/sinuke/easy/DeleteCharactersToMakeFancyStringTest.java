package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DeleteCharactersToMakeFancyStringTest {

    @ParameterizedTest
    @MethodSource("testData")
    void makeFancyString(String s, String expected) {
        var solution = new DeleteCharactersToMakeFancyString();
        assertEquals(expected, solution.makeFancyString(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("leeetcode", "leetcode"),
                Arguments.of("aaabaaaa", "aabaa"),
                Arguments.of("aab", "aab")
        );
    }

}
