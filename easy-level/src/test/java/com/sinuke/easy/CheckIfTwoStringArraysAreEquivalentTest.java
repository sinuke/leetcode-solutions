package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckIfTwoStringArraysAreEquivalentTest {

    @ParameterizedTest
    @MethodSource("testData")
    void arrayStringsAreEqual(String[] word1, String[] word2, boolean expected) {
        var check = new CheckIfTwoStringArraysAreEquivalent();
        assertEquals(expected, check.arrayStringsAreEqual(word1, word2));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new String[] {"ab", "c"}, new String[] {"a", "bc"}, true),
                Arguments.of(new String[] {"a", "cb"}, new String[] {"ab", "c"}, false),
                Arguments.of(new String[] {"abc", "d", "defg"}, new String[] {"abcddefg"}, true)
        );
    }

}
