package com.sinuke.easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountTheNumberOfVowelStringsInRangeTest {

    @ParameterizedTest
    @MethodSource("testData")
    void vowelStrings(String[] words, int left, int right, int expected) {
        var solution = new CountTheNumberOfVowelStringsInRange();
        assertEquals(expected, solution.vowelStrings(words, left, right));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new String[] {"are","amy","u"}, 0, 2, 2),
                Arguments.of(new String[] {"hey","aeo","mu","ooo","artro"}, 1, 4, 3)
        );
    }

}
